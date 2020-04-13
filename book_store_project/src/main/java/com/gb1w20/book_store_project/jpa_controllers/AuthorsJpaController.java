package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Authors_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Queries that facilitate accessing certain authors(s)
 *
 * @author Saad
 */
@Named
@RequestScoped
public class AuthorsJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public AuthorsJpaController() {
    }

    /**
     *
     * @param authors
     * @throws Exception
     */
    public void create(Authors authors) throws Exception {
        try {
            utx.begin();
            em.persist(authors);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        }
    }

    /**
     *
     * @param authors
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Authors authors) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            authors = em.merge(authors);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = authors.getAuthorID();
                if (findAuthors(id) == null) {
                    throw new NonexistentEntityException("The author with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Authors authors;
            try {
                authors = em.getReference(Authors.class, id);
                authors.getAuthorID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The author with id " + id + " no longer exists.", enfe);
            }
            em.remove(authors);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        }
    }

    /**
     *
     * @return
     */
    public List<Authors> findAuthorsEntities() {
        return findAuthorsEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Authors> findAuthorsEntities(int maxResults, int firstResult) {
        return findAuthorsEntities(false, maxResults, firstResult);
    }

    private List<Authors> findAuthorsEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Authors.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    /**
     *
     * @param id
     * @return
     */
    public Authors findAuthors(Integer id) {
        return em.find(Authors.class, id);
    }

    /**
     *
     * @return
     */
    public int getAuthorsCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Authors> rt = cq.from(Authors.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        System.out.println("author count: " + ((Long) q.getSingleResult()).intValue());
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     *
     * @return
     */
    public List<String> getAuthorNames() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Authors> author = cq.from(Authors.class);
        cq.select(author.get(Authors_.name));
        TypedQuery<String> query = em.createQuery(cq);
        return query.getResultList();
    }

    /**
     *
     * @param name
     * @return
     */
    public Authors getAuthorByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Authors> author = cq.from(Authors.class);
        cq.where(cb.equal(author.get(Authors_.name), name));
        cq.select(author);
        TypedQuery<Authors> query = em.createQuery(cq);
        return query.getSingleResult();
    }

}

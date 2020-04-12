package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.entities.Publisher_;
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
 *
 * @author Saad
 */
@Named
@RequestScoped
public class PublisherJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public PublisherJpaController() {}

    public void create(Publisher publisher) throws Exception {
    try {
        utx.begin();
        em.persist(publisher);
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

    public void edit(Publisher publisher) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            publisher = em.merge(publisher);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = publisher.getPublisherID();
                if (findPublisher(id) == null) {
                    throw new NonexistentEntityException("The publisher with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Publisher publisher;
            try {
                publisher = em.getReference(Publisher.class, id);
                publisher.getPublisherID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The publisher with id " + id + " no longer exists.", enfe);
            }
            em.remove(publisher);
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

    public List<Publisher> findPublisherEntities() {
        return findPublisherEntities(true, -1, -1);
    }

    public List<Publisher> findPublisherEntities(int maxResults, int firstResult) {
        return findPublisherEntities(false, maxResults, firstResult);
    }

    private List<Publisher> findPublisherEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Publisher.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Publisher findPublisher(Integer id) {
            return em.find(Publisher.class, id);
    }

    public int getPublisherCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Publisher> rt = cq.from(Publisher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("publisher count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<String> getPublisherNames() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Publisher> pub = cq.from(Publisher.class);
        cq.select(pub.get(Publisher_.name));
        TypedQuery<String> q = em.createQuery(cq);
        return q.getResultList();
    }
    
    
    public int getPublisherIDByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Publisher> pub = cq.from(Publisher.class);
        cq.where(cb.equal(pub.get(Publisher_.name), name));
        cq.select(pub.get(Publisher_.publisherID));
        TypedQuery<Integer> q = em.createQuery(cq);
        return q.getSingleResult();
    }
    
    public Publisher getPublisherByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Publisher> pub = cq.from(Publisher.class);
        cq.where(cb.equal(pub.get(Publisher_.name), name));
        cq.select(pub);
        TypedQuery<Publisher> q = em.createQuery(cq);
        return q.getSingleResult();
    }
    
}

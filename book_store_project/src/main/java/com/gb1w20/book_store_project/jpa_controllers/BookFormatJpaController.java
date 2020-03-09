package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.BookFormat;
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
public class BookFormatJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public BookFormatJpaController() {}

    public void create(BookFormat bookFormat) throws Exception {
    try {
        utx.begin();
        em.persist(bookFormat);
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

    public void edit(BookFormat bookFormat) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            bookFormat = em.merge(bookFormat);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bookFormat.getFormatID();
                if (findBookFormat(id) == null) {
                    throw new NonexistentEntityException("The bookFormat with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            BookFormat bookFormat;
            try {
                bookFormat = em.getReference(BookFormat.class, id);
                bookFormat.getFormatID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bookFormat with id " + id + " no longer exists.", enfe);
            }
            em.remove(bookFormat);
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

    public List<BookFormat> findBookFormatEntities() {
        return findBookFormatEntities(true, -1, -1);
    }

    public List<BookFormat> findBookFormatEntities(int maxResults, int firstResult) {
        return findBookFormatEntities(false, maxResults, firstResult);
    }

    private List<BookFormat> findBookFormatEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(BookFormat.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public BookFormat findBookFormat(Integer id) {
            return em.find(BookFormat.class, id);
    }

    public int getBookFormatCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BookFormat> rt = cq.from(BookFormat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("bookFormat count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
}

package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *  Queries that facilitate accessing certain reviews
 * @author Saad,Shruti
 */
@Named
@RequestScoped
public class CustomerReviewsJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public CustomerReviewsJpaController() {
    }

    public void create(CustomerReviews customerReviews) throws Exception {
        try {
            utx.begin();
            em.persist(customerReviews);
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

    public void edit(CustomerReviews customerReviews) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            customerReviews = em.merge(customerReviews);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = customerReviews.getReviewID();
                if (findCustomerReviews(id) == null) {
                    throw new NonexistentEntityException("The customerReview with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            CustomerReviews customerReviews;
            try {
                customerReviews = em.getReference(CustomerReviews.class, id);
                customerReviews.getReviewID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customerReview with id " + id + " no longer exists.", enfe);
            }
            em.remove(customerReviews);
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

    public List<CustomerReviews> findCustomerReviewsEntities() {
        return findCustomerReviewsEntities(true, -1, -1);
    }

    public List<CustomerReviews> findCustomerReviewsEntities(int maxResults, int firstResult) {
        return findCustomerReviewsEntities(false, maxResults, firstResult);
    }

    private List<CustomerReviews> findCustomerReviewsEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CustomerReviews.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public CustomerReviews findCustomerReviews(Integer id) {
        return em.find(CustomerReviews.class, id);
    }

    /**
     * Finds customer reviews based in isbn and clientId
     *
     * @author shruti pareek
     * @param id
     * @param isbn
     * @return
     */
    public List<CustomerReviews> findCustomerReviewsByClientId(Integer id, String isbn) {
        TypedQuery<CustomerReviews> query = em.createQuery("SELECT c FROM CustomerReviews c WHERE c.isRemoved = :removed AND c.isbn = :isbn AND c.clientID = :id", CustomerReviews.class);
        query.setParameter("removed", false);
        query.setParameter("isbn", isbn);
        query.setParameter("id", id);
        List<CustomerReviews> customerReviews = query.getResultList();
        return customerReviews;
    }

    /**
     * get average rating for a book based on isbn
     *
     * @author shruti pareek
     * @param isbn
     * @return
     */
    public double getAverageRating(String isbn) {
        TypedQuery<Object> query = em.createQuery("SELECT AVG(c.rating) FROM CustomerReviews c where c.isRemoved = :removed AND  c.pending = :pending group by c.isbn Having c.isbn = :isbn", Object.class);
        query.setParameter("isbn", isbn);
        query.setParameter("removed", false);
        query.setParameter("pending", false);
        List rating = query.getResultList();
        if (rating.isEmpty()) {
            return 0.0;
        } else if (rating.size() == 1) {
            for (Object r : rating) {
                return (double) r;
            }
        }
        throw new NonUniqueResultException();

    }

    /**
     * Get review that have not been removed based on isbn
     *
     * @author shruti pareek
     * @param isbn
     * @return
     */
    public List<CustomerReviews> getReviews(String isbn) {
        TypedQuery<CustomerReviews> query = em.createQuery("SELECT c FROM CustomerReviews c WHERE c.isRemoved = :removed AND c.isbn = :isbn AND c.pending = :pending", CustomerReviews.class);
        query.setParameter("removed", false);
        query.setParameter("isbn", isbn);
        query.setParameter("pending", false);
        List<CustomerReviews> customerReviews = query.getResultList();
        return customerReviews;
    }

    /**
     * Get the count of reviews from a book that have not been removed
     *
     * @author shruti pareek
     * @param isbn
     * @return count
     */
    public int getCustomerReviewsCount(String isbn) {
        TypedQuery<CustomerReviews> query = em.createQuery("SELECT c FROM CustomerReviews c WHERE c.isRemoved = :removed AND c.isbn = :isbn AND c.pending = :pending", CustomerReviews.class);
        query.setParameter("removed", false);
        query.setParameter("isbn", isbn);
        query.setParameter("pending", false);
        List<CustomerReviews> customerReviews = query.getResultList();
        return customerReviews.size();
    }

    /**
     * Get the count of all reviews from a book
     *
     * @return count
     */
    public int getCustomerReviewsCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<CustomerReviews> rt = cq.from(CustomerReviews.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        System.out.println("customerReview count: " + ((Long) q.getSingleResult()).intValue());
        return ((Long) q.getSingleResult()).intValue();
    }

}

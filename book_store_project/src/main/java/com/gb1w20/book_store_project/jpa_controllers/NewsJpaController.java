package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.entities.News_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Queries that facilitate accessing certain news
 * @author Saad,Shruti
 */
@Named
@RequestScoped
public class NewsJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public NewsJpaController() {
    }

    /**
     *
     * @param news
     * @throws Exception
     */
    public void create(News news) throws Exception {
        try {
            utx.begin();
            em.persist(news);
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
     * @param news
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(News news) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            news = em.merge(news);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = news.getNewsID();
                if (findNews(id) == null) {
                    throw new NonexistentEntityException("The news with id " + id + " no longer exists.");
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
            News news;
            try {
                news = em.getReference(News.class, id);
                news.getNewsID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The news with id " + id + " no longer exists.", enfe);
            }
            em.remove(news);
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
    public List<News> findNewsEntities() {
        return findNewsEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<News> findNewsEntities(int maxResults, int firstResult) {
        return findNewsEntities(false, maxResults, firstResult);
    }

    private List<News> findNewsEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(News.class));
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
    public News findNews(Integer id) {
        return em.find(News.class, id);
    }

    /**
     * Get the count of new that have not been removed
     *
     * @author shruti pareek
     * @return count
     */
    public int getNewsCount() {
        TypedQuery<News> query = em.createQuery("SELECT n FROM News n WHERE n.isRemoved = :removed", News.class);
        query.setParameter("removed", false);
        List<News> news = query.getResultList();
        return news.size();
    }

    /**
     * get random news that is not removed
     *
     * @author shrutii pareek
     * @return news
     */
    public News getRandomNews() {
        TypedQuery<News> query = em.createQuery("SELECT n FROM News n WHERE n.isRemoved = :removed", News.class);
        query.setParameter("removed", false);
        Random r = new Random();
        query.setFirstResult((r.nextInt(getNewsCount())));
        query.setMaxResults(1);
        News n = query.getSingleResult();
        return n;
    }

    /**
     *
     * @param newsID
     * @return
     */
    public Object[] getStatusByNewsId(int newsID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<News> order = cq.from(News.class);
        cq.where(cb.equal(order.get(News_.newsID), newsID));
        cq.select(order.get(News_.isRemoved));
        TypedQuery<Boolean> query = em.createQuery(cq);
        try {
            query.getSingleResult();
            Object[] returnArr = {false, "Not Removed", "Enabled"};
            return returnArr;
        } catch (NoResultException nre) {
            Object[] returnArr = {true, "Removed", "Enable News"};
            return returnArr;
        }
    }

    /**
     *
     * @return
     */
    public News getEnabledNews() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<News> news = cq.from(News.class);
        cq.where(cb.isFalse(news.get(News_.isRemoved)));
        cq.select(news);
        TypedQuery<News> query = em.createQuery(cq);
        return query.getSingleResult();
    }

}

package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Ads_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import com.gb1w20.book_store_project.util.MessageLoader;
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
 * Queries that facilitate accessing certain advertisements
 *
 * @author Saad,Shruti
 */
@Named
@RequestScoped
public class AdsJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public AdsJpaController() {
    }

    /**
     *
     * @param ads
     * @throws Exception
     */
    public void create(Ads ads) throws Exception {
        try {
            utx.begin();
            em.persist(ads);
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
     * @param ads
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Ads ads) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            ads = em.merge(ads);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ads.getAdID();
                if (findAds(id) == null) {
                    throw new NonexistentEntityException("The ad with id " + id + " no longer exists.");
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
            Ads ads;
            try {
                ads = em.getReference(Ads.class, id);
                ads.getAdID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ad with id " + id + " no longer exists.", enfe);
            }
            em.remove(ads);
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
    public List<Ads> findAdsEntities() {
        return findAdsEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Ads> findAdsEntities(int maxResults, int firstResult) {
        return findAdsEntities(false, maxResults, firstResult);
    }

    private List<Ads> findAdsEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ads.class));
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
    public Ads findAds(Integer id) {
        return em.find(Ads.class, id);
    }

    /**
     * Gets the count of advertisements that have not been removed
     *
     * @author shruti pareek
     * @return ad count
     */
    public int getAdsCount() {
        TypedQuery<Ads> query = em.createQuery("SELECT a FROM Ads a WHERE a.isRemoved = :removed", Ads.class);
        query.setParameter("removed", false);
        List<Ads> ads = query.getResultList();
        return ads.size();
    }

    /**
     * Gets a random ad from table
     *
     * @author shruti pareek
     * @return Random ad
     */
    public Ads getRandomAd() {
        TypedQuery<Ads> query = em.createQuery("SELECT a FROM Ads a WHERE a.isRemoved = :removed", Ads.class);
        query.setParameter("removed", false);
        Random r = new Random();
        query.setFirstResult((r.nextInt(getAdsCount())));
        query.setMaxResults(1);
        Ads a = query.getSingleResult();
        return a;
    }

    /**
     *
     * @param adID
     * @return
     */
    public String getStatusByAdId(int adID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Ads> order = cq.from(Ads.class);
        cq.where(cb.equal(order.get(Ads_.adID), adID));
        cq.select(order.get(Ads_.isRemoved));
        TypedQuery<Boolean> query = em.createQuery(cq);
        try {
            query.getSingleResult();
            return MessageLoader.getString("com.gb1w20.bundles.messages", "notRemoved", null);
        }
        catch(NoResultException nre)
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "removed", null);
        }
    }

    /**
     *
     * @return
     */
    public List<Ads> getAllEnabledAds() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Ads> ads = cq.from(Ads.class);
        cq.where(cb.isFalse(ads.get(Ads_.isRemoved)));
        cq.select(ads);
        TypedQuery<Ads> query = em.createQuery(cq);
        return query.getResultList();
    }

}

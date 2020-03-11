package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
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
public class SurveyDataJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public SurveyDataJpaController() {}

    public void create(SurveyData surveyData) throws Exception {
    try {
        utx.begin();
        em.persist(surveyData);
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

    public void edit(SurveyData surveyData) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            surveyData = em.merge(surveyData);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = surveyData.getDataID();
                if (findSurveyData(id) == null) {
                    throw new NonexistentEntityException("The surveyData with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            SurveyData surveyData;
            try {
                surveyData = em.getReference(SurveyData.class, id);
                surveyData.getDataID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The surveyData with id " + id + " no longer exists.", enfe);
            }
            em.remove(surveyData);
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

    public List<SurveyData> findSurveyDataEntities() {
        return findSurveyDataEntities(true, -1, -1);
    }

    public List<SurveyData> findSurveyDataEntities(int maxResults, int firstResult) {
        return findSurveyDataEntities(false, maxResults, firstResult);
    }

    private List<SurveyData> findSurveyDataEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(SurveyData.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public SurveyData findSurveyData(Integer id) {
            return em.find(SurveyData.class, id);
    }

    public int getSurveyDataCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SurveyData> rt = cq.from(SurveyData.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("surveyData count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<SurveyData> getfirstSurvey(){
        TypedQuery<SurveyData> query = em.createQuery("SELECT s FROM SurveyData s WHERE s.Survey_ID = :id", SurveyData.class);
         query.setParameter("id", 1);
        List<SurveyData> surveyData = query.getResultList();
        return surveyData; 
    }
    
}

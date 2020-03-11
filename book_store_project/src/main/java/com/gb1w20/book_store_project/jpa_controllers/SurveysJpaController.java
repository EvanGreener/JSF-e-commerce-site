package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Book;
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
public class SurveysJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public SurveysJpaController() {}

    public void create(Surveys survey) throws Exception {
    try {
        utx.begin();
        em.persist(survey);
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

    public void edit(Surveys survey) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            survey = em.merge(survey);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = survey.getSurveyID();
                if (findSurveys(id) == null) {
                    throw new NonexistentEntityException("The survey with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Surveys survey;
            try {
                survey = em.getReference(Surveys.class, id);
                survey.getSurveyID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The survey with id " + id + " no longer exists.", enfe);
            }
            em.remove(survey);
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

    public List<Surveys> findSurveysEntities() {
        return findSurveysEntities(true, -1, -1);
    }

    public List<Surveys> findSurveysEntities(int maxResults, int firstResult) {
        return findSurveysEntities(false, maxResults, firstResult);
    }

    private List<Surveys> findSurveysEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Surveys.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }
    
    public List<Surveys> getfirstSurvey(){
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s", Surveys.class);
        query.setMaxResults(1);
        List<Surveys> survey = query.getResultList();
        
        return survey; 
    }
    
    
    

    public Surveys findSurveys(Integer id) {
            return em.find(Surveys.class, id);
    }

    public int getSurveysCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Surveys> rt = cq.from(Surveys.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("survey count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
}

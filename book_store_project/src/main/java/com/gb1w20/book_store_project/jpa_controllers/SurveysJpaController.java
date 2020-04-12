package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.SurveyData_;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.entities.Surveys_;
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
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Queries that facilitate accessing certain surveys
 *
 * @author Saad,shruti
 */
@Named
@RequestScoped
public class SurveysJpaController implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveysJpaController.class);

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public SurveysJpaController() {
    }

    /**
     *
     * @param survey
     * @throws Exception
     */
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

    /**
     *
     * @param survey
     * @throws NonexistentEntityException
     * @throws Exception
     */
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

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     * @throws Exception
     */
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

    /**
     *
     * @return
     */
    public List<Surveys> findSurveysEntities() {
        return findSurveysEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
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

    /**
     *
     * @param id
     * @return
     */
    public int getTotalVotesSingleSurvey(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Surveys> surveys = cq.from(Surveys.class);
        Join surveyData = surveys.join("surveyData", JoinType.INNER);
        cq.where(cb.equal(surveys.get(Surveys_.surveyID), id));
        cq.select(cb.sum(surveyData.get(SurveyData_.votes)));
        TypedQuery<Integer> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    /**
     *
     * @param id
     * @return
     */
    public Surveys findSurveys(Integer id) {
        return em.find(Surveys.class, id);
    }

    /**
     *
     * @return
     */
    public Surveys getActiveSurvey() {
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s WHERE s.isRemoved = :removed", Surveys.class);
        query.setParameter("removed", false);
        Random r = new Random();
        query.setFirstResult((r.nextInt(getSurveysCount())));
        query.setMaxResults(1);
        Surveys s = query.getSingleResult();
        return s;
    }

    /**
     * get count of all surveys that have not been removed
     *
     * @author shruti pareek
     * @return count
     */
    public int getSurveysCount() {
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s WHERE s.isRemoved = :removed", Surveys.class);
        query.setParameter("removed", false);
        List<Surveys> survey = query.getResultList();
        return survey.size();
    }

}

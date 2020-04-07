package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.backing.AdBackingBean;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.entities.Surveys;
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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad
 */
@Named
@RequestScoped
public class SurveysJpaController implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveysJpaController.class);
    
    @Resource
    private UserTransaction utx;
    
    @PersistenceContext
    private EntityManager em;

    public SurveysJpaController() {
    }

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

    public List<Surveys> getfirstSurvey() {
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s", Surveys.class);
        query.setMaxResults(1);
        List<Surveys> survey = query.getResultList();

        return survey;
    }

    public List<Integer> getTotalVotes(int id) {
        TypedQuery<Integer> query = em.createQuery("SELECT sum(sd.votes) FROM Surveys s inner join Survey_Data sd on s.survey_ID=sd.survey_ID", Integer.class);
        // query.setParameter("id", id);
        List<Integer> sum = query.getResultList();
        return sum;
    }

    public Surveys findSurveys(Integer id) {
        return em.find(Surveys.class, id);
    }

    public Surveys getRandomSurvey() {
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s WHERE s.isRemoved = :removed", Surveys.class);
        query.setParameter("removed", false);
        Random r = new Random();
        query.setFirstResult((r.nextInt(getSurveysCount())));
        query.setMaxResults(1);
        Surveys s = query.getSingleResult();
        return s;
    }

    public int getSurveysCount() {
        TypedQuery<Surveys> query = em.createQuery("SELECT s FROM Surveys s WHERE s.isRemoved = :removed", Surveys.class);
        query.setParameter("removed", false);
        List<Surveys> survey = query.getResultList();
        return survey.size();
    }

}

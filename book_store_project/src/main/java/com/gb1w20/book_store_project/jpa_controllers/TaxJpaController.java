package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Tax;
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
public class TaxJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public TaxJpaController() {}

    public void create(Tax tax) throws Exception {
    try {
        utx.begin();
        em.persist(tax);
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

    public void edit(Tax tax) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            tax = em.merge(tax);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tax.getProvinceAbbreviation();
                if (findTax(id) == null) {
                    throw new NonexistentEntityException("The tax with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Tax tax;
            try {
                tax = em.getReference(Tax.class, id);
                tax.getProvinceAbbreviation();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tax with id " + id + " no longer exists.", enfe);
            }
            em.remove(tax);
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

    public List<Tax> findTaxEntities() {
        return findTaxEntities(true, -1, -1);
    }

    public List<Tax> findTaxEntities(int maxResults, int firstResult) {
        return findTaxEntities(false, maxResults, firstResult);
    }

    private List<Tax> findTaxEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tax.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Tax findTax(String id) {
            return em.find(Tax.class, id);
    }

    public int getTaxCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tax> rt = cq.from(Tax.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("tax count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
}

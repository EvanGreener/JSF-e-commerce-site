package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.ClientInventory;
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
public class ClientInventoryJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public ClientInventoryJpaController() {}

    public void create(ClientInventory tax) throws Exception {
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

    public void edit(ClientInventory tax) throws NonexistentEntityException, Exception {
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
                int id = tax.getInventoryID();
                if (findClientInventory(id) == null) {
                    throw new NonexistentEntityException("The client inventory with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            ClientInventory tax;
            try {
                tax = em.getReference(ClientInventory.class, id);
                tax.getInventoryID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client inventory with id " + id + " no longer exists.", enfe);
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

    public List<ClientInventory> findClientInventoryEntities() {
        return findClientInventoryEntities(true, -1, -1);
    }

    public List<ClientInventory> findClientInventoryEntities(int maxResults, int firstResult) {
        return findClientInventoryEntities(false, maxResults, firstResult);
    }

    private List<ClientInventory> findClientInventoryEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ClientInventory.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public ClientInventory findClientInventory(int id) {
            return em.find(ClientInventory.class, id);
    }
    public List<ClientInventory> findClientInventory(Integer clientId){
        TypedQuery<ClientInventory> query = em.createQuery("SELECT c FROM ClientInventory c WHERE c.clientID=:clientId ", ClientInventory.class);
        query.setParameter("clientId", clientId);
        List<ClientInventory> inventory = query.getResultList();
        return inventory;
    }
    public int getClientInventoryCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClientInventory> rt = cq.from(ClientInventory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("client inventory count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }
    
    
    
}

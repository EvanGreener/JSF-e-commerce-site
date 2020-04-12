package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.OrderItem_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
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
 * Queries that facilitate accessing certain orderItems
 * @author Saad
 */
@Named
@RequestScoped
public class OrderItemJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public OrderItemJpaController() {
    }

    /**
     *
     * @param orderItem
     * @throws Exception
     */
    public void create(OrderItem orderItem) throws Exception {
        try {
            utx.begin();
            em.persist(orderItem);
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
     * @param orderItem
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(OrderItem orderItem) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            orderItem = em.merge(orderItem);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orderItem.getItemID();
                if (findOrderItem(id) == null) {
                    throw new NonexistentEntityException("The orderItem with id " + id + " no longer exists.");
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
            OrderItem orderItem;
            try {
                orderItem = em.getReference(OrderItem.class, id);
                orderItem.getItemID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderItem with id " + id + " no longer exists.", enfe);
            }
            em.remove(orderItem);
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
    public List<OrderItem> findOrderItemEntities() {
        return findOrderItemEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<OrderItem> findOrderItemEntities(int maxResults, int firstResult) {
        return findOrderItemEntities(false, maxResults, firstResult);
    }

    private List<OrderItem> findOrderItemEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(OrderItem.class));
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
    public OrderItem findOrderItem(Integer id) {
        return em.find(OrderItem.class, id);
    }

    /**
     *
     * @return
     */
    public int getOrderItemCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<OrderItem> rt = cq.from(OrderItem.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        System.out.println("orderItem count: " + ((Long) q.getSingleResult()).intValue());
        return ((Long) q.getSingleResult()).intValue();
    }
    
    /**
     *
     * @param itemId
     * @return
     */
    public String getStatusByItemId(int itemId)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<OrderItem> order = cq.from(OrderItem.class);
        cq.where(cb.equal(order.get(OrderItem_.itemID), itemId));
        cq.select(order.get(OrderItem_.isRemoved));
        TypedQuery<Boolean> query = em.createQuery(cq);
        try
        {
            query.getSingleResult();
            return "Not Removed";
        }
        catch(NoResultException nre)
        {
            return "Removed";
        }
    }

}

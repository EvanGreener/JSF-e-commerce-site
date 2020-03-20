package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.beans.BookBean;
import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.Clients_;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.OrderItem_;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.entities.Orders_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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
public class OrdersJpaController implements Serializable {
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;
    
    private final static Logger LOG = LoggerFactory.getLogger(OrdersJpaController.class);

    public OrdersJpaController() {}

    public void create(Orders order) throws Exception {
    try {
        utx.begin();
        em.persist(order);
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

    public void edit(Orders order) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            order = em.merge(order);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = order.getOrderID();
                if (findOrders(id) == null) {
                    throw new NonexistentEntityException("The order with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Orders order;
            try {
                order = em.getReference(Orders.class, id);
                order.getOrderID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The order with id " + id + " no longer exists.", enfe);
            }
            em.remove(order);
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

    public List<Orders> findOrdersEntities() {
        return findOrdersEntities(true, -1, -1);
    }

    public List<Orders> findOrdersEntities(int maxResults, int firstResult) {
        return findOrdersEntities(false, maxResults, firstResult);
    }

    private List<Orders> findOrdersEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Orders.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Orders findOrders(Integer id) {
            return em.find(Orders.class, id);
    }

    public int getOrdersCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orders> rt = cq.from(Orders.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            System.out.println("order count: " + ((Long) q.getSingleResult()).intValue());
            return ((Long) q.getSingleResult()).intValue();
    }

    public String getClientEmailById(int clientId)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.equal(client.get(Clients_.clientID), clientId));
        cq.select(client.get(Clients_.email));
        TypedQuery<String> query = em.createQuery(cq);
        return query.getSingleResult();
    }
    
    public List<OrderItem> getOrderItemsByOrderId(int orderId)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Orders> order = cq.from(Orders.class);
        Join orderToItems = order.join("orderItemsCollection", JoinType.LEFT);
        cq.where(cb.equal(order.get(Orders_.orderID), orderId));
        cq.select(cq.from(OrderItem.class));
        TypedQuery<OrderItem> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public int getOrderItemsCountByOrderId(int orderId)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<OrderItem> orderitems = cq.from(OrderItem.class);
        cq.where(cb.equal(orderitems.get(OrderItem_.orderID), orderId));
        cq.select(cb.count(orderitems.get(OrderItem_.itemID)));
        Query query = em.createQuery(cq);
        return ((Long) query.getSingleResult()).intValue();
    }
    
    public String getStatusByOrderId(int orderId)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Orders> order = cq.from(Orders.class);
        cq.where(cb.equal(order.get(Orders_.orderID), orderId));
        cq.select(order.get(Orders_.isRemoved));
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
    
     public List<Orders> searchOrders(String query) {
          String expression = "%" + query + "%";

          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Orders> cq = cb.createQuery(Orders.class);
          Root<Orders> order = cq.from(Orders.class);
          cq.where(cb.like(order.get(Orders_.client).get(Clients_.email), expression));
          cq.select(order);
          cq.orderBy(cb.asc(order.get(Orders_.orderID)));
          TypedQuery<Orders> q = em.createQuery(cq);
          return q.getResultList();

     }
}

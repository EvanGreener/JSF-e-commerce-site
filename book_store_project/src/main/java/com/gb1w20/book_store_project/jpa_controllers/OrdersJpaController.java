package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.Clients_;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.OrderItem_;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.entities.Orders_;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import com.gb1w20.book_store_project.util.MessageLoader;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Queries that facilitate accessing certain orders
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

    /**
     *
     */
    public OrdersJpaController() {
    }

    /**
     *
     * @param order
     * @throws Exception
     */
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

    /**
     *
     * @param order
     * @throws NonexistentEntityException
     * @throws Exception
     */
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

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     * @throws Exception
     */
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

    /**
     *
     * @return
     */
    public List<Orders> findOrdersEntities() {
        return findOrdersEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
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

    /**
     *
     * @param id
     * @return
     */
    public Orders findOrders(Integer id) {
        return em.find(Orders.class, id);
    }

    /**
     *
     * @return
     */
    public int getOrdersCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Orders> rt = cq.from(Orders.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        System.out.println("order count: " + ((Long) q.getSingleResult()).intValue());
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * Gets the client email based on their ID
     * @param clientId - The ID of the client
     * @return The email of the client
     * By: Giancarlo Biasiucci
     */
    public String getClientEmailById(int clientId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.equal(client.get(Clients_.clientID), clientId));
        cq.select(client.get(Clients_.email));
        TypedQuery<String> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    /**
     * Gets the total amount of order items in a given order (based on order ID)
     * @param orderId - ID of the order
     * @return - The number of items in the given order
     * By: Giancarlo Biasiucci
     */
    public int getOrderItemsCountByOrderId(int orderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<OrderItem> orderitems = cq.from(OrderItem.class);
        cq.where(cb.equal(orderitems.get(OrderItem_.orderID), orderId));
        cq.select(cb.count(orderitems.get(OrderItem_.itemID)));
        Query query = em.createQuery(cq);
        return ((Long) query.getSingleResult()).intValue();
    }

    /**
     * Returns a String indicating the removal status of the order
     * @param orderId - ID of the order
     * @return A string indicating the removal status of the order
     * By: Giancarlo Biasiucci
     */
    public String getStatusByOrderId(int orderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Orders> order = cq.from(Orders.class);
        cq.where(cb.equal(order.get(Orders_.orderID), orderId));
        cq.select(order.get(Orders_.isRemoved));
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
     * Searches orders based on one of several criteria
     * @param query - Search query (keyword)
     * @param searchBy - Criteria to search by
     * @return - All orders that match keyword and criteria
     * @author Giancarlo Biasiucci
     */
    public List<Orders> searchOrders(String query, String searchBy) {
        String expression = "%" + query + "%";
        if (searchBy.equals("id")) {
            expression = query;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Orders> cq = cb.createQuery(Orders.class);
        Root<Orders> order = cq.from(Orders.class);
        Join orderClients = order.join("client");
        Join orderToItems = order.join("orderItemsCollection", JoinType.LEFT);
        switch (searchBy) {
            case "id":
                cq.where(cb.equal(order.get(Orders_.clientID), expression));
                break;
            case "isbn":
                cq.where(cb.like(orderToItems.get(OrderItem_.isbn), expression));
                break;
            default:
                cq.where(cb.like(orderClients.get(Clients_.email), expression));
                break;
        }
        cq.select(order);
        cq.orderBy(cb.asc(order.get(Orders_.orderID)));
        TypedQuery<Orders> q = em.createQuery(cq);
        return q.getResultList();

    }
}

package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.Clients_;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Queries that facilitate accessing certain clients
 * @author Saad
 */
@Named
@RequestScoped
public class ClientsJpaController implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(ClientsJpaController.class);

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    public ClientsJpaController() {
    }

    /**
     *
     * @param clients
     * @throws Exception
     */
    public void create(Clients clients) throws Exception {
        try {
            utx.begin();
            em.persist(clients);
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
     * @param clients
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Clients clients) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            clients = em.merge(clients);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clients.getClientID();
                if (findClients(id) == null) {
                    throw new NonexistentEntityException("The client with id " + id + " no longer exists.");
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
            Clients clients;
            try {
                clients = em.getReference(Clients.class, id);
                clients.getClientID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client with id " + id + " no longer exists.", enfe);
            }
            em.remove(clients);
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
    public List<Clients> findClientsEntities() {
        return findClientsEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Clients> findClientsEntities(int maxResults, int firstResult) {
        return findClientsEntities(false, maxResults, firstResult);
    }

    private List<Clients> findClientsEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clients.class));
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
    public Clients findClients(Integer id) {
        return em.find(Clients.class, id);
    }

    /**
     *
     * @return
     */
    public int getClientsCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Clients> rt = cq.from(Clients.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        System.out.println("client count: " + ((Long) q.getSingleResult()).intValue());
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     *
     * @param email
     * @return
     * @throws NoResultException
     */
    public Object[] getInfoByEmail(String email) throws NoResultException{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.equal(client.get(Clients_.email), email));
        cq.multiselect(client.get(Clients_.email), client.get(Clients_.hashedPassword), client.get(Clients_.isManager), client.get(Clients_.firstName), client.get(Clients_.clientID), client.get(Clients_.provinceAbbreviation));
        TypedQuery<Object[]> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    /**
     *
     * @param email
     * @return
     */
    public List<String> getEmailsByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.equal(client.get(Clients_.email), email));
        cq.select(client.get(Clients_.email));
        TypedQuery<String> query = em.createQuery(cq);
        return query.getResultList();
    }

    /**
     *
     * @param email
     * @return
     */
    public Clients findClientByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.equal(client.get(Clients_.email), email));
        cq.select(client);
        TypedQuery<Clients> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    /**
     * SELECT c.email, c.fname, c.lname, SUM(price_sold) FROM clients c LEFT
     * JOIN orders o ON c.client_id = o.client_id LEFT JOIN orderItems oi oN
     * o.order_id = oi.order_id WHERE c.email LIKE :query AND c.is_manager =
     * false GROUP BY c.client_id, c.fname, c.lname;
     *
     * @param query
     * @param searchBy
     * @return
     */
    public List<Object[]> searchClients(String query, String searchBy) {
        String expression = "%" + query + "%";
        if (searchBy.equals("id"))
        {
            expression = query;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Clients> client = cq.from(Clients.class);
        Join clientOrders = client.join("ordersCollection", JoinType.LEFT);
        Join orderOrderItems = clientOrders.join("orderItemsCollection", JoinType.LEFT);
        switch(searchBy)
        {
            case "email":
                cq.where(cb.and(cb.isFalse(client.get(Clients_.isManager)), cb.like(client.get(Clients_.email), expression)));
                break;
            default:
                cq.where(cb.and(cb.isFalse(client.get(Clients_.isManager)), cb.equal(client.get(Clients_.clientID), expression)));
                break;
        }
        cq.groupBy(client.get(Clients_.clientID));
        cq.multiselect(
                client.get(Clients_.clientID),
                client.get(Clients_.email),
                client.get(Clients_.firstName),
                client.get(Clients_.lastName),
                client.get(Clients_.address1),
                client.get(Clients_.address2),
                client.get(Clients_.companyName),
                client.get(Clients_.cellTelephone),
                cb.sum(orderOrderItems.get(OrderItem_.priceSold)));
        TypedQuery<Object[]> q = em.createQuery(cq);
        return q.getResultList();

    }

    /**
     *
     * @param query
     * @return
     */
    public List<Object[]> searchClientsNoSum(String query) {
        String expression = "%" + query + "%";

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Clients> client = cq.from(Clients.class);
        cq.where(cb.and(cb.isFalse(client.get(Clients_.isManager)), cb.like(client.get(Clients_.email), expression)));
        cq.groupBy(client.get(Clients_.clientID));
        cq.multiselect(
                client.get(Clients_.clientID),
                client.get(Clients_.email),
                client.get(Clients_.firstName),
                client.get(Clients_.lastName),
                client.get(Clients_.address1),
                client.get(Clients_.address2),
                client.get(Clients_.companyName),
                client.get(Clients_.cellTelephone));
        TypedQuery<Object[]> q = em.createQuery(cq);
        return q.getResultList();

    }

}

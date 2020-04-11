/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.BookAuthors;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Shruti Pareek
 */
@Named
@RequestScoped
public class BookAuthorsJpaController implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public BookAuthorsJpaController() {
    }

    private EntityManagerFactory emf = null;

    public void create(BookAuthors bookAuthors) throws Exception {

        try {
            utx.begin();
            em.persist(bookAuthors);
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

    public void edit(BookAuthors bookAuthors) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            bookAuthors = em.merge(bookAuthors);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bookAuthors.getBookAuthorID();
                if (findBookAuthors(id) == null) {
                    throw new NonexistentEntityException("The bookAuthors with id " + id + " no longer exists.");
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
            BookAuthors bookAuthors;
            try {
                bookAuthors = em.getReference(BookAuthors.class, id);
                bookAuthors.getBookAuthorID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bookAuthors with id " + id + " no longer exists.", enfe);
            }
            em.remove(bookAuthors);
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

    public List<BookAuthors> findBookAuthorsEntities() {
        return findBookAuthorsEntities(true, -1, -1);
    }

    public List<BookAuthors> findBookAuthorsEntities(int maxResults, int firstResult) {
        return findBookAuthorsEntities(false, maxResults, firstResult);
    }

    private List<BookAuthors> findBookAuthorsEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(BookAuthors.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public BookAuthors findBookAuthors(Integer id) {

        return em.find(BookAuthors.class, id);

    }

    public List<BookAuthors> findBookAuthorsByIsbn(String isbn) {
        TypedQuery<BookAuthors> query = em.createQuery("SELECT ba FROM BookAuthors ba WHERE ba.isbn = :isbn", BookAuthors.class);
        query.setParameter("isbn", isbn);
        List<BookAuthors> bookAuthors = query.getResultList();
        return bookAuthors;
    }

    public int getBookAuthorsCount() {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<BookAuthors> rt = cq.from(BookAuthors.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }

}

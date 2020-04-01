package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Authors_;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Book_;
import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.OrderItem_;
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
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
 */
@Named
@RequestScoped
public class BookJpaController implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(BookJpaController.class);

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public BookJpaController() {
    }

    public void create(Book books) throws Exception {
        try {
            utx.begin();
            em.persist(books);
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

    public void edit(Book books) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            books = em.merge(books);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new Exception("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = Integer.parseInt(books.getIsbn());
                if (findBook(id) == null) {
                    throw new NonexistentEntityException("The book with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, Exception {
        try {
            utx.begin();
            Book books;
            try {
                books = em.getReference(Book.class, id);
                books.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The book with id " + id + " no longer exists.", enfe);
            }
            em.remove(books);
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

    public List<Book> findBookEntities() {
        return findBookEntities(true, -1, -1);
    }

    public List<Book> findBookEntities(int maxResults, int firstResult) {
        return findBookEntities(false, maxResults, firstResult);
    }

    private List<Book> findBookEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Book.class));

        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Book findBook(Integer id) {
        return em.find(Book.class, id);
    }
    
    public Book findSingleBook(String id){
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isRemoved = :removed AND b.isbn=:isbn", Book.class);
        query.setParameter("removed", false);
        query.setParameter("isbn", id);
        Book book = query.getSingleResult();
        return book;
    }
    
    public List<Book> findBook(String id){
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isRemoved = :removed AND b.isbn=:isbn", Book.class);
        query.setParameter("removed", false);
        query.setParameter("isbn", id);
        List<Book> books = query.getResultList();
        return books;
    }

    public int getBookCount() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isRemoved = :removed", Book.class);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books.size();
    }

    public List<Book> search(String searchBy, String q, int page) {

        String expression = "%" + q + "%";

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> book = cq.from(Book.class);
        Join author = book.join("authorsCollection");

        switch (searchBy) {
            case "title":
                cq.where(cb.like(book.get(Book_.title), expression));
                break;
            case "author":
                cq.where(cb.like(author.get(Authors_.name), expression));
                break;
            default:
                cq.where(cb.like(book.get(Book_.isbn), expression));
                break;
        }

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();

    }


    public List<Book> getBestSeller() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b INNER JOIN b.orders o where b.isRemoved = :removed GROUP BY o.isbn ORDER BY count(o.isbn) DESC", Book.class);
        query.setMaxResults(8);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Object> getPopularGenres() {

        TypedQuery<Object> query = em.createQuery("SELECT b.genre FROM Book b WHERE b.genre <> :genre AND b.isRemoved = :removed GROUP BY b.genre", Object.class);

        query.setParameter("genre", "Fiction");
        query.setParameter("removed", false);
        query.setMaxResults(4);
        List<Object> genres = query.getResultList();
        return genres;

    }

    public int getSimilarGenresBookCount(Book b) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.genre = :genre AND b.isbn <> :isbn AND b.isRemoved = :removed", Book.class);
        query.setParameter("genre", b.getGenre());
        query.setParameter("isbn", b.getIsbn());
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books.size();
    }

    public List<Book> getSimilarGenres(Book b, Integer a) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b inner join b.authorsCollection a WHERE b.genre = :genre AND b.isbn <> :isbn AND a.authorID <> :author AND b.isRemoved = :removed", Book.class);
        query.setParameter("genre", b.getGenre());
        query.setParameter("isbn", b.getIsbn());
        query.setParameter("removed", false);
        query.setParameter("author", a);
        Random r = new Random();
        query.setFirstResult((r.nextInt((getSimilarGenresBookCount(b) - 4))));
        query.setMaxResults(4);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getSimilarAuthors(Integer a, String b) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b inner join b.authorsCollection a WHERE a.authorID = :author AND b.isRemoved = :removed AND b.isbn <> :isbn ", Book.class);
        query.setParameter("author", a);
        query.setParameter("isbn", b);
        query.setParameter("removed", false);
        query.setMaxResults(4);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getRecentlyAdded() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.isRemoved = :removed ORDER BY b.dateEntered ASC", Book.class);
        query.setMaxResults(3);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getRecommended() {

        return null;
    }

}

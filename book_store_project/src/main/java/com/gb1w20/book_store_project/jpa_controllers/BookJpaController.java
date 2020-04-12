package com.gb1w20.book_store_project.jpa_controllers;

import com.gb1w20.book_store_project.entities.Authors_;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Book_;
import com.gb1w20.book_store_project.entities.OrderItem_;
import com.gb1w20.book_store_project.entities.Orders;

import com.gb1w20.book_store_project.entities.RankedBook;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
 * Queries that facilitate accessing certain books
 *
 * @author Saad, Shruti Pareek,
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

    public List<Book> findNonRemovedBooks() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Book> book = cq.from(Book.class);
        cq.where(em.getCriteriaBuilder().isFalse(book.get(Book_.isRemoved)));
        cq.select(book);
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }

    public Book findBook(Integer id) {
        return em.find(Book.class, id);
    }

    /**
     * Find a book from isbn that has not been removed
     *
     * @Shruti Pareek
     * @param isbn
     * @return Book
     */
    public Book findBook(String id) {
        Book book;
        try {

            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isRemoved = :removed AND b.isbn=:isbn", Book.class);
            query.setParameter("removed", false);
            query.setParameter("isbn", id);

            book = query.getSingleResult();
        } catch (NoResultException e) {
            book = null;
        }
        return book;
    }

    public Book findAnySingleBook(String id) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isbn=:isbn", Book.class);
        query.setParameter("isbn", id);
        Book book = query.getSingleResult();
        return book;
    }

    public List<Book> findBookAll(String id) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isbn=:isbn", Book.class);
        query.setParameter("isbn", id);
        List<Book> books = query.getResultList();
        return books;
    }

    /**
     * Count Books that have not been removed
     *
     * @Shruti Pareek
     * @return count
     */
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
                cq.where(cb.and(cb.isFalse(book.get(Book_.isRemoved))), cb.like(book.get(Book_.title), expression));
                break;
            case "author":
                cq.where(cb.and(cb.isFalse(book.get(Book_.isRemoved))), cb.like(author.get(Authors_.name), expression));
                break;
            default:
                cq.where(cb.and(cb.isFalse(book.get(Book_.isRemoved))), cb.like(book.get(Book_.isbn), expression));
                break;
        }

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Book> searchAllBooks(String searchBy, String q, int page) {

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

    /**
     * Get books that have the most orders
     *
     * @Shruti Pareek
     * @return Best seller books
     */
    public List<Book> getBestSeller() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b INNER JOIN b.orders o where b.isRemoved = :removed GROUP BY o.isbn ORDER BY count(o.isbn) DESC", Book.class);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getAllNonRemovedBooks() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.isRemoved = :removed ", Book.class);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    /**
     * Gets all books with sales by checking if list price is not equal to
     * saleprice
     *
     * @Shruti Pareek
     * @return books
     */
    public List<Book> getSaleBooks() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.isRemoved = :removed AND b.listPrice  <> b.salePrice", Book.class);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getAllSaleBooks() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.listPrice  <> b.salePrice", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getAllNotOnSaleBooks() {

        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.listPrice = b.salePrice", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    /**
     * Gets 4 most popular genres (does not include fiction) by looking at how
     * many books have that genre in the bookstore that have not been removed
     *
     * @Shruti Pareek
     * @return books
     */
    public List<Object> getPopularGenres() {

        TypedQuery<Object> query = em.createQuery("SELECT b.genre FROM Book b WHERE b.genre <> :genre AND b.isRemoved = :removed GROUP BY b.genre", Object.class);

        query.setParameter("genre", "Fiction");
        query.setParameter("removed", false);
        query.setMaxResults(4);
        List<Object> genres = query.getResultList();
        return genres;

    }

    /**
     * Get the count of books that have same genre as book it is given
     *
     * @param book
     * @Shruti Pareek
     * @return int
     */
    public int getSimilarGenresBookCount(Book b) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.genre = :genre AND b.isbn <> :isbn AND b.isRemoved = :removed", Book.class);
        query.setParameter("genre", b.getGenre());
        query.setParameter("isbn", b.getIsbn());
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books.size();
    }

    /**
     * Used for recommending books to user
     *
     * @param genre
     * @Shruti Pareek
     * @return books
     */
    public List<Book> getSimilarGenres(String genre) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b inner join b.authorsCollection a WHERE b.genre = :genre AND b.isRemoved = :removed", Book.class);
        query.setParameter("genre", genre);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    /**
     * Gets books that belong in same genre excluding books written by the
     * author
     *
     * @param book
     * @param authorId
     * @Shruti Pareek
     * @return books
     */
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

    /**
     * Gets books written by same author excluding book given
     *
     * @param authorId
     * @param isbn
     * @Shruti Pareek
     * @return books
     */
    public List<Book> getSimilarAuthors(Integer a, String b) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b inner join b.authorsCollection a WHERE a.authorID = :author AND b.isRemoved = :removed AND b.isbn <> :isbn ", Book.class);
        query.setParameter("author", a);
        query.setParameter("isbn", b);
        query.setParameter("removed", false);
        query.setMaxResults(4);
        List<Book> books = query.getResultList();
        return books;
    }

    /**
     * Gets books that have been recently added to book table
     *
     * @Shruti Pareek
     * @return books
     */
    public List<Book> getRecentlyAdded() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.isRemoved = :removed ORDER BY b.dateEntered ASC", Book.class);
        query.setMaxResults(3);
        query.setParameter("removed", false);
        List<Book> books = query.getResultList();
        return books;
    }

    public List<String> getAllISBN() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Book> book = cq.from(Book.class);
        cq.select(book.get(Book_.isbn));
        TypedQuery<String> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Book> getRecommended() {

        return null;
    }

    public String getStatusByIsbn(String isbn) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Book> order = cq.from(Book.class);
        cq.where(cb.equal(order.get(Book_.isbn), isbn));
        cq.select(order.get(Book_.isRemoved));
        TypedQuery<Boolean> query = em.createQuery(cq);
        try {
            query.getSingleResult();
            return "Not Removed";
        } catch (NoResultException nre) {
            return "Removed";
        }
    }

    public List<RankedBook> getTopSellingBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT B FROM Book B, OrderItem OI Where B.isbn = OI.isbn", Book.class);
        List<Book> orderedBooks = query.getResultList();
        TypedQuery<String> query2 = em.createQuery("SELECT CAST(COUNT(OI.isbn) AS CHAR(30)) as sales FROM Book B, OrderItem OI Where B.isbn = OI.isbn Order By sales DESC", String.class);
        List<String> bookSales = query2.getResultList();
        List<RankedBook> results = new ArrayList<RankedBook>();
        int i = 0;
        for (Book b : orderedBooks) {
            results.add(new RankedBook(b, "1"));
            i++;
        }

        return results;
    }

    public double getTotalSalesByIsbn(String isbn) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Orders> books = cq.from(Orders.class);
        Join ordersToItems = books.join("orderItemsCollection", JoinType.LEFT);
        cq.where(cb.equal(ordersToItems.get(OrderItem_.isbn), isbn));
        cq.select(cb.sumAsDouble(ordersToItems.get(OrderItem_.priceSold)));
        TypedQuery<Double> query = em.createQuery(cq);
        return query.getSingleResult() == null ? 0 : query.getSingleResult();
    }
}

package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.ChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 06spa
 */
@Named("bb")
@SessionScoped
public class BookBean implements Serializable {

    @Inject
    private BookJpaController bookCtrlr;
    private final static Logger LOG = LoggerFactory.getLogger(BookBean.class);
    private List<Book> bestSeller;
    private List<Object> popularGenres;
    private List<Book> recentlyAdded;
    private Book book;
    private List<Book> similarGenreBooks;
    private List<Book> similarAuthorBooks;
    private String genre;
    private int bookSlideColor = 0;
    private String isbn;

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }

    public int getBookSlideColor() {
        LOG.debug("getBookSlideColor");
        if (bookSlideColor == 0) {
            bookSlideColor++;
        } else if (bookSlideColor == 1) {
            bookSlideColor++;
        } else if (bookSlideColor == 2) {
            bookSlideColor++;
        } else {
            bookSlideColor = 1;
        }
        return bookSlideColor;
    }

    public List<Book> getBestSeller() {
        LOG.debug("getBestSeller");
        bestSeller = bookCtrlr.getBestSeller();
        return bestSeller;
    }

    public List<Object> getPopularGenres() {
        LOG.debug("getPopularGenres");
        popularGenres = bookCtrlr.getPopularGenres();
        return popularGenres;
    }

    public List<Book> getRecentlyAdded() {
        LOG.debug("getRecentlyAdded");
        recentlyAdded = bookCtrlr.getRecentlyAdded();
        return recentlyAdded;
    }

    /**
     * Get books with similar genre that user is currently viewing
     *
     * @param book
     * @return similarGenreBooks
     */
    public List<Book> getSimilarGenreBooks(Book book, List<Authors> author) {
        LOG.debug("getSimilarGenreBooks");
        similarGenreBooks = bookCtrlr.getSimilarGenres(book, author.get(0).getAuthorID());
        return similarGenreBooks;
    }

    /**
     * Returns only a part of book description
     *
     * @param book
     * @return description - 300 characters
     */
    public String getDisplayBookDescription(String description) {
        LOG.debug("getDisplayBookDescription");
        if (description.length() > (300 + 2)) {
            return description.substring(0, 300 - 1);
        }
        return description;
    }

    public String getHiddenBookDescription(String description) {
        LOG.debug("getHiddenBookDescription");

        return description.substring(300 - 1, description.length());
    }

    /**
     * Get books with similar author that user is currently viewing
     *
     * @param book
     * @return getSimilarAuthorBooks
     */
    public List<Book> getSimilarAuthorBooks(List<Authors> author, String isbn) {
        LOG.debug("getSimilarAuthorBooks");
        similarAuthorBooks = bookCtrlr.getSimilarAuthors(author.get(0).getAuthorID(), isbn);
        return similarAuthorBooks;
    }

    public void setGenre(String genre) {
        LOG.debug("setGenre");
        this.genre = genre;
    }

    public String getGenre() {
        LOG.debug("getGenre");
        return this.genre;
    }
    
    //https://stackoverflow.com/questions/9391838/how-to-provide-a-file-download-from-a-jsf-backing-bean
    //https://itqna.net/questions/15083/how-download-pdf-file-jsf
    public void download() throws IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

    ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
    ec.setResponseContentType("application/pdf"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
    //ec.setResponseContentLength(contentLength); 
    String filename="Alice_in_Wonderland.pdf";
// Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

    OutputStream output = ec.getResponseOutputStream();
   
    URL url = new URL("https://www.adobe.com/be_en/active-use/pdf/Alice_in_Wonderland.pdf");
    InputStream pdfInputStream = url.openStream();

    byte[] bytesBuffer = new byte[2048];
    int bytesRead;
    while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
        output.write(bytesBuffer, 0, bytesRead);
    }    
    output.flush();

    pdfInputStream.close();
    output.close();         

    fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}
    public void findBook(String isbn) throws IOException {
        LOG.debug("findBook");
        /*
        TODO: redirect to error page because this book does not exist or is removed
         */
        if (this.bookCtrlr.findBook(isbn) == null || this.bookCtrlr.findBook(isbn).size() == 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("index.xhtml");
           
        }
        else{
        this.book = this.bookCtrlr.findBook(isbn).get(0);
        }

    }

    public Book getBook() throws IOException {
        LOG.debug("getBook");
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String isbn = params.get("isbn");

        if (isbn != null) {
            LOG.debug("getBook" + isbn);
            this.isbn = isbn;
            findBook(isbn);
        }

        return this.book;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "customer_reviews", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "CustomerReviews.findAll", query = "SELECT c FROM CustomerReviews c"),
    @NamedQuery(name = "CustomerReviews.findByReviewID", query = "SELECT c FROM CustomerReviews c WHERE c.reviewID = :reviewID"),
    @NamedQuery(name = "CustomerReviews.findByClientID", query = "SELECT c FROM CustomerReviews c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "CustomerReviews.findByIsbn", query = "SELECT c FROM CustomerReviews c WHERE c.isbn = :isbn"),
    @NamedQuery(name = "CustomerReviews.findByRating", query = "SELECT c FROM CustomerReviews c WHERE c.rating = :rating"),
    @NamedQuery(name = "CustomerReviews.findByReviewBody", query = "SELECT c FROM CustomerReviews c WHERE c.reviewBody = :reviewBody"),
    @NamedQuery(name = "CustomerReviews.findByReviewTitle", query = "SELECT c FROM CustomerReviews c WHERE c.reviewTitle = :reviewTitle"),
    @NamedQuery(name = "CustomerReviews.findByIsRemoved", query = "SELECT c FROM CustomerReviews c WHERE c.isRemoved = :isRemoved"),
    @NamedQuery(name = "CustomerReviews.findByPending", query = "SELECT c FROM CustomerReviews c WHERE c.pending = :pending"),
    @NamedQuery(name = "CustomerReviews.findByLastModified", query = "SELECT c FROM CustomerReviews c WHERE c.lastModified = :lastModified"),
    @NamedQuery(name = "CustomerReviews.findByDateEntered", query = "SELECT c FROM CustomerReviews c WHERE c.dateEntered = :dateEntered"),
    @NamedQuery(name = "CustomerReviews.findByDateRemoved", query = "SELECT c FROM CustomerReviews c WHERE c.dateRemoved = :dateRemoved")})
public class CustomerReviews implements Serializable {

    @Size(max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Size(max = 10000)
    @Column(name = "Review_Body")
    private String reviewBody;
    @Size(max = 100)
    @Column(name = "Review_Title")
    private String reviewTitle;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Review_ID")
    private Integer reviewID;
    @Column(name = "Client_ID")
    private Integer clientID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rating")
    private Integer rating;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;
    @Column(name = "Pending")
    private Boolean pending;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Date_Entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    @Column(name = "Date_Removed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRemoved;

    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;

    @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID", insertable = false, updatable = false)
    @ManyToOne(optional=false,fetch = FetchType.EAGER)
    private Clients clients;

    public Clients getClients() {
        return clients;
    }

    public Book getBook() {
        return book;
    }

    public CustomerReviews() {
    }

    public CustomerReviews(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }


    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }


    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewID != null ? reviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerReviews)) {
            return false;
        }
        CustomerReviews other = (CustomerReviews) object;
        if ((this.reviewID == null && other.reviewID != null) || (this.reviewID != null && !this.reviewID.equals(other.reviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.CustomerReviews[ reviewID=" + reviewID + " ]";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}

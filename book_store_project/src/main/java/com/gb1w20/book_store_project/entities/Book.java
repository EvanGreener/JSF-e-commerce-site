/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "book", catalog = "bookstore", schema = "")
@NamedQueries({
     @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
     @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
     @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
     @NamedQuery(name = "Book.findByPublisherID", query = "SELECT b FROM Book b WHERE b.publisherID = :publisherID"),
     @NamedQuery(name = "Book.findByDateOfPublication", query = "SELECT b FROM Book b WHERE b.dateOfPublication = :dateOfPublication"),
     @NamedQuery(name = "Book.findByNumOfPages", query = "SELECT b FROM Book b WHERE b.numOfPages = :numOfPages"),
     @NamedQuery(name = "Book.findByGenre", query = "SELECT b FROM Book b WHERE b.genre = :genre"),
     @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
     @NamedQuery(name = "Book.findByWholesalePrice", query = "SELECT b FROM Book b WHERE b.wholesalePrice = :wholesalePrice"),
     @NamedQuery(name = "Book.findByListPrice", query = "SELECT b FROM Book b WHERE b.listPrice = :listPrice"),
     @NamedQuery(name = "Book.findBySalePrice", query = "SELECT b FROM Book b WHERE b.salePrice = :salePrice"),
     @NamedQuery(name = "Book.findByDateEntered", query = "SELECT b FROM Book b WHERE b.dateEntered = :dateEntered"),
     @NamedQuery(name = "Book.findByLastModified", query = "SELECT b FROM Book b WHERE b.lastModified = :lastModified"),
     @NamedQuery(name = "Book.findByIsRemoved", query = "SELECT b FROM Book b WHERE b.isRemoved = :isRemoved")})
public class Book implements Serializable {

     private static final long serialVersionUID = 1L;
     @Id
     @Basic(optional = false)
     @NotNull
     @Size(min = 1, max = 13)
     @Column(name = "ISBN")
     private String isbn;
     @Size(max = 500)
     @Column(name = "Title")
     private String title;
     @Column(name = "Publisher_ID")
     private Integer publisherID;
     @Column(name = "Date_Of_Publication")
     @Temporal(TemporalType.TIMESTAMP)
     private Date dateOfPublication;
     @Column(name = "Num_Of_Pages")
     private Integer numOfPages;
     @Size(max = 50)
     @Column(name = "Genre")
     private String genre;
     @Size(max = 10000)
     @Column(name = "Description")
     private String description;
     // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @Column(name = "Wholesale_Price")
     private BigDecimal wholesalePrice;
     @Column(name = "List_Price")
     private BigDecimal listPrice;
     @Column(name = "Sale_Price")
     private BigDecimal salePrice;
     @Column(name = "Date_Entered")
     @Temporal(TemporalType.TIMESTAMP)
     private Date dateEntered;
     @Column(name = "Last_Modified")
     @Temporal(TemporalType.TIMESTAMP)
     private Date lastModified;
     @Column(name = "Is_Removed")
     private Boolean isRemoved;

     @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinTable(
             name = "Book_Authors",
             joinColumns = {
                  @JoinColumn(name = "ISBN")},
             inverseJoinColumns = {
                  @JoinColumn(name = "Author_ID")}
     )
     private List<Authors> authorsCollection;

     public Book() {
     }

     public Book(String isbn) {
          this.isbn = isbn;
     }

     public String getIsbn() {
          return isbn;
     }

     public void setIsbn(String isbn) {
          this.isbn = isbn;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public Integer getPublisherID() {
          return publisherID;
     }

     public void setPublisherID(Integer publisherID) {
          this.publisherID = publisherID;
     }

     public Date getDateOfPublication() {
          return dateOfPublication;
     }

     public void setDateOfPublication(Date dateOfPublication) {
          this.dateOfPublication = dateOfPublication;
     }

     public Integer getNumOfPages() {
          return numOfPages;
     }

     public void setNumOfPages(Integer numOfPages) {
          this.numOfPages = numOfPages;
     }

     public String getGenre() {
          return genre;
     }

     public void setGenre(String genre) {
          this.genre = genre;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public BigDecimal getWholesalePrice() {
          return wholesalePrice;
     }

     public void setWholesalePrice(BigDecimal wholesalePrice) {
          this.wholesalePrice = wholesalePrice;
     }

     public BigDecimal getListPrice() {
          return listPrice;
     }

     public void setListPrice(BigDecimal listPrice) {
          this.listPrice = listPrice;
     }

     public BigDecimal getSalePrice() {
          return salePrice;
     }

     public void setSalePrice(BigDecimal salePrice) {
          this.salePrice = salePrice;
     }

     public Date getDateEntered() {
          return dateEntered;
     }

     public void setDateEntered(Date dateEntered) {
          this.dateEntered = dateEntered;
     }

     public Date getLastModified() {
          return lastModified;
     }

     public void setLastModified(Date lastModified) {
          this.lastModified = lastModified;
     }

     public Boolean getIsRemoved() {
          return isRemoved;
     }

     public void setIsRemoved(Boolean isRemoved) {
          this.isRemoved = isRemoved;
     }

     public List<Authors> getAuthorsCollection() {
          return authorsCollection;
     }

     @Override
     public int hashCode() {
          int hash = 0;
          hash += (isbn != null ? isbn.hashCode() : 0);
          return hash;
     }

     @Override
     public boolean equals(Object object) {
          // TODO: Warning - this method won't work in the case the id fields are not set
          if (!(object instanceof Book)) {
               return false;
          }
          Book other = (Book) object;
          if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
               return false;
          }
          return true;
     }

     @Override
     public String toString() {
          return "Book[ title=" + title + ", isbn=" + isbn + " ]";
     }

}

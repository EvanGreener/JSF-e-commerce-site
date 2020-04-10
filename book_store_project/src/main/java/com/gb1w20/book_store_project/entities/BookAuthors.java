/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Shruti Pareek
 */
@Entity
@Table(name = "book_authors")
@NamedQueries({
    @NamedQuery(name = "BookAuthors.findAll", query = "SELECT b FROM BookAuthors b"),
    @NamedQuery(name = "BookAuthors.findByBookAuthorID", query = "SELECT b FROM BookAuthors b WHERE b.bookAuthorID = :bookAuthorID"),
    @NamedQuery(name = "BookAuthors.findByAuthorID", query = "SELECT b FROM BookAuthors b WHERE b.authorID = :authorID"),
    @NamedQuery(name = "BookAuthors.findByIsbn", query = "SELECT b FROM BookAuthors b WHERE b.isbn = :isbn")})
public class BookAuthors implements Serializable {

    @Size(max = 13)
    @Column(name = "ISBN")
    private String isbn;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookAuthor_ID")
    private Integer bookAuthorID;
    @Column(name = "Author_ID")
    private Integer authorID;

    public BookAuthors() {
    }

    public BookAuthors(Integer bookAuthorID) {
        this.bookAuthorID = bookAuthorID;
    }

    public Integer getBookAuthorID() {
        return bookAuthorID;
    }

    public void setBookAuthorID(Integer bookAuthorID) {
        this.bookAuthorID = bookAuthorID;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookAuthorID != null ? bookAuthorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookAuthors)) {
            return false;
        }
        BookAuthors other = (BookAuthors) object;
        if ((this.bookAuthorID == null && other.bookAuthorID != null) || (this.bookAuthorID != null && !this.bookAuthorID.equals(other.bookAuthorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.BookAuthors[ bookAuthorID=" + bookAuthorID + " ]";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
}

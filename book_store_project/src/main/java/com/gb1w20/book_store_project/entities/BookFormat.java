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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "book_format", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookFormat.findAll", query = "SELECT b FROM BookFormat b"),
    @NamedQuery(name = "BookFormat.findByFormatID", query = "SELECT b FROM BookFormat b WHERE b.formatID = :formatID"),
    @NamedQuery(name = "BookFormat.findByIsbn", query = "SELECT b FROM BookFormat b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "BookFormat.findByFormat", query = "SELECT b FROM BookFormat b WHERE b.format = :format"),
    @NamedQuery(name = "BookFormat.findByFileLocation", query = "SELECT b FROM BookFormat b WHERE b.fileLocation = :fileLocation"),
    @NamedQuery(name = "BookFormat.findByDateCreated", query = "SELECT b FROM BookFormat b WHERE b.dateCreated = :dateCreated"),
    @NamedQuery(name = "BookFormat.findByLastModified", query = "SELECT b FROM BookFormat b WHERE b.lastModified = :lastModified"),
    @NamedQuery(name = "BookFormat.findByIsRemoved", query = "SELECT b FROM BookFormat b WHERE b.isRemoved = :isRemoved")})
public class BookFormat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Format_ID")
    private Integer formatID;
    @Size(max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Size(max = 6)
    @Column(name = "Format")
    private String format;
    @Size(max = 1000)
    @Column(name = "File_Location")
    private String fileLocation;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public BookFormat() {
    }

    public BookFormat(Integer formatID) {
        this.formatID = formatID;
    }

    public Integer getFormatID() {
        return formatID;
    }

    public void setFormatID(Integer formatID) {
        this.formatID = formatID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formatID != null ? formatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookFormat)) {
            return false;
        }
        BookFormat other = (BookFormat) object;
        if ((this.formatID == null && other.formatID != null) || (this.formatID != null && !this.formatID.equals(other.formatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.BookFormat[ formatID=" + formatID + " ]";
    }
    
}

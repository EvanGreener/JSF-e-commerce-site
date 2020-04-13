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
@Table(name = "news", catalog = "gb1w20", schema = "")
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByRSSFeed", query = "SELECT n FROM News n WHERE n.rSSFeed = :rSSFeed"),
    @NamedQuery(name = "News.findByDateCreated", query = "SELECT n FROM News n WHERE n.dateCreated = :dateCreated"),
    @NamedQuery(name = "News.findByDateEnded", query = "SELECT n FROM News n WHERE n.dateEnded = :dateEnded"),
    @NamedQuery(name = "News.findByIsRemoved", query = "SELECT n FROM News n WHERE n.isRemoved = :isRemoved"),
    @NamedQuery(name = "News.findByLastModified", query = "SELECT n FROM News n WHERE n.lastModified = :lastModified")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "News_ID")
    private Integer newsID;
    @Size(max = 500)
    @Column(name = "RSS_Feed")
    private String rSSFeed;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Date_Ended")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnded;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getRSSFeed() {
        return rSSFeed;
    }

    public void setRSSFeed(String rSSFeed) {
        this.rSSFeed = rSSFeed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.News[ newsID=" + newsID + " ]";
    }
    
}

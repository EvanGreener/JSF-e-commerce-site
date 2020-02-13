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
@Table(name = "ads", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ads.findAll", query = "SELECT a FROM Ads a"),
    @NamedQuery(name = "Ads.findByAdID", query = "SELECT a FROM Ads a WHERE a.adID = :adID"),
    @NamedQuery(name = "Ads.findByImageName", query = "SELECT a FROM Ads a WHERE a.imageName = :imageName"),
    @NamedQuery(name = "Ads.findByAdUrl", query = "SELECT a FROM Ads a WHERE a.adUrl = :adUrl"),
    @NamedQuery(name = "Ads.findByDateCreated", query = "SELECT a FROM Ads a WHERE a.dateCreated = :dateCreated"),
    @NamedQuery(name = "Ads.findByLastModified", query = "SELECT a FROM Ads a WHERE a.lastModified = :lastModified"),
    @NamedQuery(name = "Ads.findByIsRemoved", query = "SELECT a FROM Ads a WHERE a.isRemoved = :isRemoved")})
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Ad_ID")
    private Integer adID;
    @Size(max = 500)
    @Column(name = "Image_Name")
    private String imageName;
    @Size(max = 1000)
    @Column(name = "Ad_Url")
    private String adUrl;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public Ads() {
    }

    public Ads(Integer adID) {
        this.adID = adID;
    }

    public Integer getAdID() {
        return adID;
    }

    public void setAdID(Integer adID) {
        this.adID = adID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
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
        hash += (adID != null ? adID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ads)) {
            return false;
        }
        Ads other = (Ads) object;
        if ((this.adID == null && other.adID != null) || (this.adID != null && !this.adID.equals(other.adID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.Ads[ adID=" + adID + " ]";
    }
    
}

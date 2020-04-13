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
@Table(name = "publisher", catalog = "gb1w20", schema = "")
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPublisherID", query = "SELECT p FROM Publisher p WHERE p.publisherID = :publisherID"),
    @NamedQuery(name = "Publisher.findByName", query = "SELECT p FROM Publisher p WHERE p.name = :name"),
    @NamedQuery(name = "Publisher.findByAddress", query = "SELECT p FROM Publisher p WHERE p.address = :address"),
    @NamedQuery(name = "Publisher.findByCity", query = "SELECT p FROM Publisher p WHERE p.city = :city"),
    @NamedQuery(name = "Publisher.findByCountry", query = "SELECT p FROM Publisher p WHERE p.country = :country"),
    @NamedQuery(name = "Publisher.findByPostalCode", query = "SELECT p FROM Publisher p WHERE p.postalCode = :postalCode"),
    @NamedQuery(name = "Publisher.findByContactName", query = "SELECT p FROM Publisher p WHERE p.contactName = :contactName"),
    @NamedQuery(name = "Publisher.findByPhoneNumber", query = "SELECT p FROM Publisher p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Publisher.findByDateCreated", query = "SELECT p FROM Publisher p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "Publisher.findByLastModified", query = "SELECT p FROM Publisher p WHERE p.lastModified = :lastModified"),
    @NamedQuery(name = "Publisher.findByIsRemoved", query = "SELECT p FROM Publisher p WHERE p.isRemoved = :isRemoved")})
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Publisher_ID")
    private Integer publisherID;
    @Size(max = 300)
    @Column(name = "Name")
    private String name;
    @Size(max = 500)
    @Column(name = "Address")
    private String address;
    @Size(max = 100)
    @Column(name = "City")
    private String city;
    @Size(max = 100)
    @Column(name = "Country")
    private String country;
    @Size(max = 20)
    @Column(name = "Postal_Code")
    private String postalCode;
    @Size(max = 100)
    @Column(name = "Contact_Name")
    private String contactName;
    @Size(max = 10)
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public Publisher() {
    }

    public Publisher(Integer publisherID) {
        this.publisherID = publisherID;
    }

    public Integer getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Integer publisherID) {
        this.publisherID = publisherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        hash += (publisherID != null ? publisherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.publisherID == null && other.publisherID != null) || (this.publisherID != null && !this.publisherID.equals(other.publisherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.Publisher[ publisherID=" + publisherID + " ]";
    }
    
}

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
@Table(name = "clients", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientID", query = "SELECT c FROM Clients c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "Clients.findByIsManager", query = "SELECT c FROM Clients c WHERE c.isManager = :isManager"),
    @NamedQuery(name = "Clients.findByFirstName", query = "SELECT c FROM Clients c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Clients.findByLastName", query = "SELECT c FROM Clients c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Clients.findByCompanyName", query = "SELECT c FROM Clients c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Clients.findByAddress1", query = "SELECT c FROM Clients c WHERE c.address1 = :address1"),
    @NamedQuery(name = "Clients.findByAddress2", query = "SELECT c FROM Clients c WHERE c.address2 = :address2"),
    @NamedQuery(name = "Clients.findByCity", query = "SELECT c FROM Clients c WHERE c.city = :city"),
    @NamedQuery(name = "Clients.findByProvinceAbbreviation", query = "SELECT c FROM Clients c WHERE c.provinceAbbreviation = :provinceAbbreviation"),
    @NamedQuery(name = "Clients.findByCountry", query = "SELECT c FROM Clients c WHERE c.country = :country"),
    @NamedQuery(name = "Clients.findByPostalCode", query = "SELECT c FROM Clients c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "Clients.findByHomeTelephone", query = "SELECT c FROM Clients c WHERE c.homeTelephone = :homeTelephone"),
    @NamedQuery(name = "Clients.findByCellTelephone", query = "SELECT c FROM Clients c WHERE c.cellTelephone = :cellTelephone"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByDateEntered", query = "SELECT c FROM Clients c WHERE c.dateEntered = :dateEntered"),
    @NamedQuery(name = "Clients.findByLastModified", query = "SELECT c FROM Clients c WHERE c.lastModified = :lastModified"),
    @NamedQuery(name = "Clients.findByIsRemoved", query = "SELECT c FROM Clients c WHERE c.isRemoved = :isRemoved")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Client_ID")
    private Integer clientID;
    @Column(name = "Is_Manager")
    private Boolean isManager;
    @Size(max = 50)
    @Column(name = "First_Name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "Last_Name")
    private String lastName;
    @Size(max = 100)
    @Column(name = "Company_Name")
    private String companyName;
    @Size(max = 300)
    @Column(name = "Address_1")
    private String address1;
    @Size(max = 300)
    @Column(name = "Address_2")
    private String address2;
    @Size(max = 100)
    @Column(name = "City")
    private String city;
    @Column(name = "Province_Abbreviation")
    private Integer provinceAbbreviation;
    @Size(max = 30)
    @Column(name = "Country")
    private String country;
    @Size(max = 6)
    @Column(name = "Postal_Code")
    private String postalCode;
    @Size(max = 10)
    @Column(name = "Home_Telephone")
    private String homeTelephone;
    @Size(max = 10)
    @Column(name = "Cell_Telephone")
    private String cellTelephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 300)
    @Column(name = "Email")
    private String email;
    @Column(name = "Date_Entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public Clients() {
    }
    
    public Clients(String firstName,
            String lastName,
            String companyName,
            String address1,
            String address2,
            String city,
            int provinceAbbr,
            String country,
            String postalCode,
            String homePhone,
            String cellPhone,
            String email)
    {
        this.isManager = false;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.provinceAbbreviation = provinceAbbr;
        this.country = country;
        this.postalCode = postalCode;
        this.homeTelephone = homePhone;
        this.cellTelephone = cellPhone;
        this.email = email;
        this.dateEntered = new Date();
        this.lastModified = new Date();
        this.isRemoved = false;
    }

    public Clients(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getProvinceAbbreviation() {
        return provinceAbbreviation;
    }

    public void setProvinceAbbreviation(Integer provinceAbbreviation) {
        this.provinceAbbreviation = provinceAbbreviation;
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

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getCellTelephone() {
        return cellTelephone;
    }

    public void setCellTelephone(String cellTelephone) {
        this.cellTelephone = cellTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.Clients[ clientID=" + clientID + " ]";
    }
    
}

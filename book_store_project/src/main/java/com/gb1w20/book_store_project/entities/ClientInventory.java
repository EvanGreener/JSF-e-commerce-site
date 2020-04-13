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
 * @author giancarlo
 */
@Entity
@Table(name = "Client_Inventory", catalog = "gb1w20", schema = "")
@NamedQueries({
    @NamedQuery(name = "ClientInventory.findAll", query = "SELECT c FROM ClientInventory c"),
    @NamedQuery(name = "ClientInventory.findByInventoryID", query = "SELECT c FROM ClientInventory c WHERE c.inventoryID = :inventoryID"),
    @NamedQuery(name = "ClientInventory.findByClientID", query = "SELECT c FROM ClientInventory c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "ClientInventory.findByIsbn", query = "SELECT c FROM ClientInventory c WHERE c.isbn = :isbn"),
    @NamedQuery(name = "ClientInventory.findByDatePurchased", query = "SELECT c FROM ClientInventory c WHERE c.datePurchased = :datePurchased"),
    @NamedQuery(name = "ClientInventory.findByLastModified", query = "SELECT c FROM ClientInventory c WHERE c.lastModified = :lastModified"),
    @NamedQuery(name = "ClientInventory.findByIsRemoved", query = "SELECT c FROM ClientInventory c WHERE c.isRemoved = :isRemoved")})
public class ClientInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Inventory_ID")
    private Integer inventoryID;
    @Column(name = "Client_ID")
    private Integer clientID;
    @Size(max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "Date_Purchased")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePurchased;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public ClientInventory() {
    }

    public ClientInventory(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
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
        hash += (inventoryID != null ? inventoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientInventory)) {
            return false;
        }
        ClientInventory other = (ClientInventory) object;
        if ((this.inventoryID == null && other.inventoryID != null) || (this.inventoryID != null && !this.inventoryID.equals(other.inventoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.ClientInventory[ inventoryID=" + inventoryID + " ]";
    }
    
}

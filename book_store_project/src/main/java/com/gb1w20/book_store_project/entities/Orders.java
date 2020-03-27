/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "orders", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderID", query = "SELECT o FROM Orders o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Orders.findByClientID", query = "SELECT o FROM Orders o WHERE o.clientID = :clientID"),
    @NamedQuery(name = "Orders.findByDateCreated", query = "SELECT o FROM Orders o WHERE o.dateCreated = :dateCreated"),
    @NamedQuery(name = "Orders.findByLastUpdated", query = "SELECT o FROM Orders o WHERE o.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "Orders.findByIsRemoved", query = "SELECT o FROM Orders o WHERE o.isRemoved = :isRemoved")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Order_ID")
    private Integer orderID;
    @Column(name = "Client_ID")
    private Integer clientID;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;
    
    @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clients client;
    
    @OneToMany(  cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_ID")
    private List<OrderItem> orderItemsCollection;


    public Orders() {}

    public Orders(Integer orderID) {
        this.orderID = orderID;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItemsCollection;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
    
    public List<OrderItem> getOrderItemsCollection() {
         return orderItemsCollection;
    }
    
    public void setOrderItemsCollection(List<OrderItem> newList)
    {
        orderItemsCollection = newList;
    }
    
    public Clients getClient(){
         return client;
    }
    
    public void setClient(Clients newValue)
    {
        client = newValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.Orders[ orderID=" + orderID + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "order_item", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
    @NamedQuery(name = "OrderItem.findByItemID", query = "SELECT o FROM OrderItem o WHERE o.itemID = :itemID"),
    @NamedQuery(name = "OrderItem.findByOrderID", query = "SELECT o FROM OrderItem o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderItem.findByIsbn", query = "SELECT o FROM OrderItem o WHERE o.isbn = :isbn"),
    @NamedQuery(name = "OrderItem.findByPriceSold", query = "SELECT o FROM OrderItem o WHERE o.priceSold = :priceSold"),
    @NamedQuery(name = "OrderItem.findByLastUpdated", query = "SELECT o FROM OrderItem o WHERE o.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "OrderItem.findByIsRemoved", query = "SELECT o FROM OrderItem o WHERE o.isRemoved = :isRemoved")})
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Item_ID")
    private Integer itemID;
    @Column(name = "Order_ID")
    private Integer orderID;
    @Size(max = 13)
    @Column(name = "ISBN")
    private String isbn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price_Sold")
    private Double priceSold;
    @Column(name = "Last_Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;
    
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book ba;

    public OrderItem() {
    }
    
    public Book getBa(){
        return ba;
    }
    public OrderItem(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(Double priceSold) {
        this.priceSold = priceSold;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.OrderItem[ itemID=" + itemID + " ]";
    }
    
}

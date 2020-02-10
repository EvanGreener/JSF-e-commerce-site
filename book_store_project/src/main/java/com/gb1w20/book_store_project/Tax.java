/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "tax")
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t"),
    @NamedQuery(name = "Tax.findByProvinceAbbreviation", query = "SELECT t FROM Tax t WHERE t.provinceAbbreviation = :provinceAbbreviation"),
    @NamedQuery(name = "Tax.findByGst", query = "SELECT t FROM Tax t WHERE t.gst = :gst"),
    @NamedQuery(name = "Tax.findByPst", query = "SELECT t FROM Tax t WHERE t.pst = :pst"),
    @NamedQuery(name = "Tax.findByHst", query = "SELECT t FROM Tax t WHERE t.hst = :hst")})
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Province_Abbreviation")
    private String provinceAbbreviation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GST")
    private BigDecimal gst;
    @Column(name = "PST")
    private BigDecimal pst;
    @Column(name = "HST")
    private BigDecimal hst;

    public Tax() {
    }

    public Tax(String provinceAbbreviation) {
        this.provinceAbbreviation = provinceAbbreviation;
    }

    public String getProvinceAbbreviation() {
        return provinceAbbreviation;
    }

    public void setProvinceAbbreviation(String provinceAbbreviation) {
        this.provinceAbbreviation = provinceAbbreviation;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public BigDecimal getPst() {
        return pst;
    }

    public void setPst(BigDecimal pst) {
        this.pst = pst;
    }

    public BigDecimal getHst() {
        return hst;
    }

    public void setHst(BigDecimal hst) {
        this.hst = hst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceAbbreviation != null ? provinceAbbreviation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.provinceAbbreviation == null && other.provinceAbbreviation != null) || (this.provinceAbbreviation != null && !this.provinceAbbreviation.equals(other.provinceAbbreviation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.Tax[ provinceAbbreviation=" + provinceAbbreviation + " ]";
    }
    
}

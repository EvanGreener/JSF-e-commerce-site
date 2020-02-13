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
@Table(name = "survey_data", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "SurveyData.findAll", query = "SELECT s FROM SurveyData s"),
    @NamedQuery(name = "SurveyData.findByDataID", query = "SELECT s FROM SurveyData s WHERE s.dataID = :dataID"),
    @NamedQuery(name = "SurveyData.findBySurveyID", query = "SELECT s FROM SurveyData s WHERE s.surveyID = :surveyID"),
    @NamedQuery(name = "SurveyData.findByChoice", query = "SELECT s FROM SurveyData s WHERE s.choice = :choice"),
    @NamedQuery(name = "SurveyData.findByVotes", query = "SELECT s FROM SurveyData s WHERE s.votes = :votes"),
    @NamedQuery(name = "SurveyData.findByDateCreated", query = "SELECT s FROM SurveyData s WHERE s.dateCreated = :dateCreated"),
    @NamedQuery(name = "SurveyData.findByLastModified", query = "SELECT s FROM SurveyData s WHERE s.lastModified = :lastModified"),
    @NamedQuery(name = "SurveyData.findByIsRemoved", query = "SELECT s FROM SurveyData s WHERE s.isRemoved = :isRemoved")})
public class SurveyData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Data_ID")
    private Integer dataID;
    @Column(name = "Survey_ID")
    private Integer surveyID;
    @Size(max = 200)
    @Column(name = "Choice")
    private String choice;
    @Column(name = "Votes")
    private Integer votes;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;

    public SurveyData() {
    }

    public SurveyData(Integer dataID) {
        this.dataID = dataID;
    }

    public Integer getDataID() {
        return dataID;
    }

    public void setDataID(Integer dataID) {
        this.dataID = dataID;
    }

    public Integer getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(Integer surveyID) {
        this.surveyID = surveyID;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
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
        hash += (dataID != null ? dataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveyData)) {
            return false;
        }
        SurveyData other = (SurveyData) object;
        if ((this.dataID == null && other.dataID != null) || (this.dataID != null && !this.dataID.equals(other.dataID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.SurveyData[ dataID=" + dataID + " ]";
    }
    
}

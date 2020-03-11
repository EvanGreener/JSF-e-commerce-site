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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author 1733408
 */
@Entity
@Table(name = "surveys", catalog = "bookstore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Surveys.findAll", query = "SELECT s FROM Surveys s"),
    @NamedQuery(name = "Surveys.findBySurveyID", query = "SELECT s FROM Surveys s WHERE s.surveyID = :surveyID"),
    @NamedQuery(name = "Surveys.findBySurveyDescription", query = "SELECT s FROM Surveys s WHERE s.surveyDescription = :surveyDescription"),
    @NamedQuery(name = "Surveys.findBySurveyName", query = "SELECT s FROM Surveys s WHERE s.surveyName = :surveyName"),
    @NamedQuery(name = "Surveys.findByDateCreated", query = "SELECT s FROM Surveys s WHERE s.dateCreated = :dateCreated"),
    @NamedQuery(name = "Surveys.findByLastModified", query = "SELECT s FROM Surveys s WHERE s.lastModified = :lastModified"),
    @NamedQuery(name = "Surveys.findByIsRemoved", query = "SELECT s FROM Surveys s WHERE s.isRemoved = :isRemoved")})
public class Surveys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Survey_ID")
    private Integer surveyID;
    @Size(max = 500)
    @Column(name = "Survey_Description")
    private String surveyDescription;
    @Size(max = 100)
    @Column(name = "Survey_Name")
    private String surveyName;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Last_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Is_Removed")
    private Boolean isRemoved;
    
     @OneToMany(cascade = CascadeType.ALL,mappedBy="survey")
    private List<SurveyData> surveyData;

    public Surveys() {
    }
    public  List<SurveyData> getSurveyData(){
        return surveyData;
    }
    public Surveys(Integer surveyID) {
        this.surveyID = surveyID;
    }

    public Integer getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(Integer surveyID) {
        this.surveyID = surveyID;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
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
        hash += (surveyID != null ? surveyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surveys)) {
            return false;
        }
        Surveys other = (Surveys) object;
        if ((this.surveyID == null && other.surveyID != null) || (this.surveyID != null && !this.surveyID.equals(other.surveyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gb1w20.book_store_project.entities.Surveys[ surveyID=" + surveyID + " ]";
    }
    
}

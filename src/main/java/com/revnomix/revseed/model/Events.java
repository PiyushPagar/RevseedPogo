package com.revnomix.revseed.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "events")
public class Events implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "area_impact")
    private String areaImpact;

    @Column(name = "regdate")
    private Date regDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author",referencedColumnName = "accountId",insertable = false,updatable = false,foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Accounts accounts;

    @Column(name = "author")
    private Integer author;

    @Access(AccessType.FIELD)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RowStatus status;

    @Column(name = "client_id")
    private Integer clientId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAreaImpact() {
        return areaImpact;
    }

    public void setAreaImpact(String areaImpact) {
        this.areaImpact = areaImpact;
    }

    public Date getRegdate() {
        return regDate;
    }

    public void setRegdate(Date regdate) {
        this.regDate = regdate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public RowStatus getStatus() {
        return status;
    }

    public void setStatus(RowStatus status) {
        this.status = status;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Transient
    public String getAuthorFname(){

        return accounts!=null?accounts.getAccountFirstName():"";
    }

    @Transient
    public String getAuthorLname(){
        return accounts!=null?accounts.getAccountLastName():"";
    }
}


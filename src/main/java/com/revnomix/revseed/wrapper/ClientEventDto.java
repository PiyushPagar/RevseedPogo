package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.RowStatus;

import javax.persistence.Transient;
import java.util.Date;

public class ClientEventDto {
    private Integer id;
    private String name;
    private String type;
    private String startDate;
    private String endDate;
    private String areaImpact;
    private Date regDate;
    private Integer author;
    private RowStatus status;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
}


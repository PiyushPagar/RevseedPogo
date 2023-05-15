package com.revnomix.revseed.wrapper;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;

public class ScheduledJobDto implements Serializable {

    public ScheduledJobDto() {

    }

    private Integer id;
    private Integer clientId;
    private String propertyName;
    private Date startDate;
    private Date endDate;
    private String jobType;
    private String status;
    private String response;
    private Integer count;

    public ScheduledJobDto(Integer id, Integer client_id, String property_name, Date start_date_time, Date end_date_time, String job_type,String response, String status) {
        this.id = id;
        this.clientId = client_id;
        this.propertyName = property_name;
        this.startDate = start_date_time;
        this.endDate = end_date_time;
        this.jobType = job_type;
        this.response = response;
        this.status = status;
    }

    public ScheduledJobDto(Integer client_id, String status, Integer counts) {
        this.clientId = client_id;
        this.status = status;
        this.count = counts;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.revnomix.revseed.model;

import javax.persistence.*;

@Entity
public class RmQueues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer rateshop;
    @Column(name = "rm_rateshop")
    private Integer rmRateshop;
    @Column(name = "rm_id")
    private Integer rmId;
    @Column(name = "time_Remaining")
    private Integer timeRemaining;
    @Column(name = "status_Code")
    private Integer statusCode;
    @Column(name = "progress_Code")

    private Integer progressCode;
    @Column(name = "credits_Used")

    private Integer creditsUsed;
    @Column(name = "total_Rows")
    private Integer totalRows;
    @Column(name = "status")
    private String status;
    @Column(name = "author")
    private Integer author;
    @Column(name = "notify_Email")

    private String notifyEmail;
    @Column(name = "created_By")
    private String createdBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRateshop() {
        return rateshop;
    }

    public void setRateshop(Integer rateshop) {
        this.rateshop = rateshop;
    }

    public Integer getRmRateshop() {
        return rmRateshop;
    }

    public void setRmRateshop(Integer rmRateshop) {
        this.rmRateshop = rmRateshop;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Integer timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getProgressCode() {
        return progressCode;
    }

    public void setProgressCode(Integer progressCode) {
        this.progressCode = progressCode;
    }

    public Integer getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(Integer creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

package com.revnomix.revseed.model;

import javax.persistence.*;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_Id")
    private Integer clientId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alertType",referencedColumnName = "id",insertable = false,updatable = false,foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private AlertType alertType;
    private Integer alertConfigurationId;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAlertConfigurationId() {
        return alertConfigurationId;
    }

    public void setAlertConfigurationId(Integer alertConfigurationId) {
        this.alertConfigurationId = alertConfigurationId;
    }
}


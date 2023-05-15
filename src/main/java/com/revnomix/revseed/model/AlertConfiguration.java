package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AlertConfiguration extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="alert_type")
    private String alertType;
    
    @Column(name="status")
    private String status;
    
    @Column(name="account_id")
    private Integer accountId;
    
    @Column(name="client_id")
    private Integer clientId;
}




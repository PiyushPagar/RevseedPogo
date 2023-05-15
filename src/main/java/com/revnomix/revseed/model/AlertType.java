package com.revnomix.revseed.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AlertType extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "body")
    private String body;
    
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "updatedBy")
    private String updatedBy;
    
}

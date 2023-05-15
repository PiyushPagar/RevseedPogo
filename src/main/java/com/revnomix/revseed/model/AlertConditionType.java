package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AlertConditionType extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "config_id")
    private Integer configId;
    
    @Column(name = "start_date")
    private Date startDate;
    
    @Column(name = "end_date")
    private Date endDate;
    
    @Column(name = "start_window")
    private Integer startWindow;
    
    @Column(name = "end_window")
    private Integer endWindow;
    
    @Column(name = "intervals")
    private Integer intervals;
    
    @Column(name = "interval_type")
    private String intervalType;
    
    @Column(name = "status")
    private String status;
}

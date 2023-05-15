package com.revnomix.revseed.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "scheduler_timing_alt")
public class SchedulerTimingAlt  extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "client_id")
    private Long clientId;
    
    @Column(name = "scheduler_name")
    private String schedulerName;
    
    @Column(name = "timing")
    private Time timing;
    
    @Column(name = "is_run_today")
    private Boolean isRunToday;
}

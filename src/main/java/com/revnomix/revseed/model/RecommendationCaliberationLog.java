package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "recom_calib_log")
public class RecommendationCaliberationLog extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "client_id")
    private Long clientId;
	
	@Column(name = "hotel_id")
	private Long hotelId;
	
	@Column(name="run_datetime")
	private Date runDateTime;
	
	@Column(name= "process_type", length = 50)
	private String processType;
	
	@Column(name="process_status",length = 50)
	private String processStatus;
}

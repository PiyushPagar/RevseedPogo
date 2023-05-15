package com.revnomix.revseed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;


@Table(name = "monitoring_dashboard")
@Immutable
@Entity
@Data
public class MonitoringDasboard {

	@Id
	@Column(name = "client_id")
	private Long clientId;
	@Column(name = "property_name")
	private String propertyName;
	@Column(name = "hotel_id")
	private Long hotelId;
	@Column(name = "rm_code")
	private Long rmCode;
	@Column(name = "city")
	private String city;
	@Column(name = "account_email")
	private String emailId;
	@Column(name = "account_manager")
	private Integer accountManager;
	@Column(name = "capacity")
	private Integer capacity;
	@Column(name = "status")
	private String status;
	@Column(name = "rate_push_enable")
	private Boolean ratePushEnable;
	@Column(name = "run_calibration")
	private String runCaliberation;
	@Column(name = "run_recommendation")
	private String runRecommendation;
	@Column(name = "bkg_date")
	private Date bookingDate;
	@Column(name = "checkin_date")
	private Date checkinDate;
	@Column(name = "checkout_date")
	private Date checkOutDate;
	@Column(name = "inv_date")
	private Date inventorySyncDate;
	@Column(name = "inv_avilability")
	private Date inventoryAvailability;
	@Column(name = "rate_date")
	private Date rateSyncDate;
	@Column(name = "rate_availability")
	private Date rateAvailability;
	@Column(name = "hnf_date")
	private Date hnfDate;
	@Column(name = "calibration_date")
	private Date caliberationDate;
	@Column(name = "recommendation_date")
	private Date recommendationDate;
	
	
}

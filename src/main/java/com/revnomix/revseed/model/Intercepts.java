package com.revnomix.revseed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "intercepts")
@Entity
public class Intercepts {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name = "hotel_id")
	private Integer hotelId;
    
    @Column(name = "client_id")
	private Integer clientId;
    
    @Column(name = "season_number")
	private Integer seasonNumber;
    
    @Column(name = "dow1")
	private Float dow1;
    
    @Column(name = "dow2")
	private Float dow2;
    
    @Column(name = "dow3")
	private Float dow3;
    
    @Column(name = "dow4")
	private Float dow4;
    
    @Column(name = "dow5")
	private Float dow5;
    
    @Column(name = "dow6")
	private Float dow6;
    
    @Column(name = "dow7")
	private Float dow7;
    
    @Column(name = "week_days")
	private Float weekDays;
    
    @Column(name = "week_ends")
	private Float weekends;
    
    @Column(name = "all_days")
	private Float allDays;
	
}

package com.revnomix.revseed.wrapper;

import java.util.Map;

import lombok.Data;

@Data
public class ISellReportDto {

	private String date;
	private String dow;
	private String season;
	private String eventName;
	private String eventType;
	private Integer hotelCap;
	private Integer availCap;
	private Integer sold;
	private Integer pickup;
	private Integer revenue;
	private Integer adr;
	private String strategy;
	private Integer sysRate;
	private Integer recommend;
	private Integer compMin;
	private Integer compAvg;
	private Integer compMax;
	private Map<String,Integer> compMinRate;
	
}

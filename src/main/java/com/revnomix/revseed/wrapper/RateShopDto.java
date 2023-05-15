package com.revnomix.revseed.wrapper;

import java.util.Date;

import lombok.Data;

@Data	
public class RateShopDto {
	private String hotelName;
	private Date checkin;
	private String month;
	private String websiteName;
	private String tax;
	private String mealInclusionType;
	private String roomTypeDescription;
	private String rateType;
	private Double onsiteRate;
	private Double netRate;
	private String currency;
	
	RateShopDto(){
		
	}

	public RateShopDto(String hotelName, Date checkin, String month, String websiteName, String tax,
			String mealInclusionType, String roomTypeDescription, String rateType, Double onsiteRate, Double netRate,
			String currency) {
		super();
		this.hotelName = hotelName;
		this.checkin = checkin;
		this.month = month;
		this.websiteName = websiteName;
		this.tax = tax;
		this.mealInclusionType = mealInclusionType;
		this.roomTypeDescription = roomTypeDescription;
		this.rateType = rateType;
		this.onsiteRate = onsiteRate;
		this.netRate = netRate;
		this.currency = currency;
	}
	
	
}

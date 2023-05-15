package com.revnomix.revseed.wrapper;

import java.util.Date;


public class CompetitorPricingDto {

    private Date occupancyDate;
    private Double min;
    private Double max;
    private Double avg;
    private String name;
    private String categoryName;
    private Date regDate;
    private String otaName;
    private Double onsiteRate;
    private String hotelCode;
    private String occupancyDateStr;

    public CompetitorPricingDto() {}
    
    public CompetitorPricingDto(Date occupancyDate, Double min, Double max, Double avg) {
        this.occupancyDate = occupancyDate;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }
    
    public CompetitorPricingDto(Date occupancyDate,String hotelCode, Double onsiteRate) {
        this.occupancyDate = occupancyDate;
        this.onsiteRate = onsiteRate;
        this.hotelCode = hotelCode;
    }

    public CompetitorPricingDto(Date occupancyDate, Double min, String name) {
        this.occupancyDate = occupancyDate;
        this.min = min;
        this.name = name;
    }

    public CompetitorPricingDto(Date occupancyDate, Double min, String name, String categoryName,String otaName,Date regDate) {
        this.occupancyDate = occupancyDate;
        this.min = min;
        this.name = name;
        this.categoryName = categoryName;
        this.regDate = regDate;
        this.otaName = otaName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

	public Double getOnsiteRate() {
		return onsiteRate;
	}

	public void setOnsiteRate(Double onsiteRate) {
		this.onsiteRate = onsiteRate;
	}

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}

	public String getOccupancyDateStr() {
		return occupancyDateStr;
	}

	public void setOccupancyDateStr(String occupancyDateStr) {
		this.occupancyDateStr = occupancyDateStr;
	}
    
    
}

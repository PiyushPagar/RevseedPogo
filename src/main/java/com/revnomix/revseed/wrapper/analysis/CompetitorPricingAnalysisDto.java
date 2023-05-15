package com.revnomix.revseed.wrapper.analysis;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CompetitorPricingAnalysisDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    private Date occupancyDate;
    private String dow;
    private Double min;
    private String name;
    private Integer hotelId;

    public CompetitorPricingAnalysisDto(Date occupancyDate, String dow, Double min, String name, Integer hotelId) {
        this.occupancyDate = occupancyDate;
        this.dow = dow;
        this.min = min;
        this.name = name;
        this.hotelId = hotelId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


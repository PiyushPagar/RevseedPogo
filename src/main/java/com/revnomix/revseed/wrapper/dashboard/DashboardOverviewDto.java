package com.revnomix.revseed.wrapper.dashboard;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DashboardOverviewDto {
    private Date occupancyDate;
    private String dow;
    private Integer capacity;
    private Integer availableCapacity;
    private Integer sold;
    private Integer pickup;
    private Double revenue;
    private Double adr;
    private Double min;
    private Double max;
    private Double avg;
    private Double rateOnCm;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
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

    public Double getRateOnCm() {
        return rateOnCm;
    }

    public void setRateOnCm(Double rateOnCm) {
        this.rateOnCm = rateOnCm;
    }
}

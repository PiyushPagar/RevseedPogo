package com.revnomix.revseed.wrapper.analysis;

public class TrendByOtaDtoAndDate {
    private String date;
    private String otaName;
    private Double revenue;
    private Integer rooms;
    private String dow;
    private Integer capacity;
    private Integer availableCapacity;
    private Integer sold;
    private Integer pickup;
    private Double adr;

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

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
    }

    public TrendByOtaDtoAndDate(String date, Double revenue, Integer rooms) {
        this.date = date;
        this.revenue = revenue;
        this.rooms = rooms;
    }

    public TrendByOtaDtoAndDate(String date, String otaName, Double revenue, Integer rooms) {
        this.date = date;
        this.otaName = otaName;
        this.revenue = revenue;
        this.rooms = rooms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
}

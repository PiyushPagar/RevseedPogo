package com.revnomix.revseed.wrapper;


import java.util.Date;

public class OtaPerformanceDto {
    private Date occupancyDate;
    private String dow;
    private Integer capacity;
    private Integer availableCapacity;
    private Integer sold;
    private Integer pickup;
    private Double revenue;
    private Double adr; 
    private Integer grossPickup;
    private Integer otaId;
    private String roomName;
    private String otaName;

    public OtaPerformanceDto(){}

    public OtaPerformanceDto(Integer sold, Double revenue, Double adr){
        this.sold = sold;
        this.revenue = revenue;
        this.adr = adr;
    }

    public OtaPerformanceDto(Integer sold, Double revenue, Double adr, Integer pickup){
        this.sold = sold;
        this.pickup = pickup;
        this.revenue = revenue;
        this.adr = adr;
    }
    
    public OtaPerformanceDto(Integer sold, Double revenue, Double adr, Integer pickup,Integer otaId){
        this.sold = sold;
        this.pickup = pickup;
        this.revenue = revenue;
        this.adr = adr;
        this.otaId = otaId;
    }
    
    public OtaPerformanceDto(Double revenue, Integer pickup,Integer otaId){
        this.pickup = pickup;
        this.revenue = revenue;
        this.otaId = otaId;
    }
    
    public OtaPerformanceDto(Double revenue, Integer pickup,String otaName){
        this.pickup = pickup;
        this.revenue = revenue;
        this.otaName = otaName;
    }

    public OtaPerformanceDto(Date occupancyDate, String dow, Integer availableCapacity, Integer capacity, Integer sold, Double revenue, Double adr) {
        this.occupancyDate = occupancyDate;
        this.dow = dow;
        this.capacity = capacity;
        this.availableCapacity = availableCapacity;
        this.sold = sold;
        this.revenue = revenue;
        this.adr = adr;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
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

	public Integer getGrossPickup() {
		return grossPickup;
	}

	public void setGrossPickup(Integer grossPickup) {
		this.grossPickup = grossPickup;
	}

	public Integer getOtaId() {
		return otaId;
	}

	public void setOtaId(Integer otaId) {
		this.otaId = otaId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getOtaName() {
		return otaName;
	}

	public void setOtaName(String otaName) {
		this.otaName = otaName;
	}
    
    
}

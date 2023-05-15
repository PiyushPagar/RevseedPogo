package com.revnomix.revseed.wrapper.dashboard;

public class TrendByOtaDto {
    String otaName;
    Double revenue;
    Integer rooms;
    Double adr;
    Integer capacity;

    public TrendByOtaDto(String otaName, Double revenue, Integer rooms) {
        this.otaName = otaName;
        this.revenue = revenue;
        this.rooms = rooms;
    }
    
    public TrendByOtaDto(String otaName, Double revenue, Integer rooms,Double adr, Integer capacity) {
        this.otaName = otaName;
        this.revenue = revenue;
        this.rooms = rooms;
        this.adr = adr;
        this.capacity = capacity;
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

	public Double getAdr() {
		return adr;
	}

	public void setAdr(Double adr) {
		this.adr = adr;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
    
    
}

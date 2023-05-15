package com.revnomix.revseed.wrapper.dashboard;

import java.util.Date;

public class PickupTrendDto {
    Date occupancyDate;
    Double revenue;
    Integer rooms;
    Double adr;
    Integer capacity;

    public PickupTrendDto(Date occupancyDate, Double revenue, Integer rooms) {
        this.occupancyDate = occupancyDate;
        this.revenue = revenue;
        this.rooms = rooms;
    }
    
    public PickupTrendDto(Date occupancyDate, Double revenue, Integer rooms, Double adr,Integer capacity) {
        this.occupancyDate = occupancyDate;
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

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
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

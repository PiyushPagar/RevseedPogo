package com.revnomix.revseed.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class OccupancyByDateDto implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    private Integer rooms;
    private Float adr;
    private Float revenue;
    private String name;
    private Date occupancy_date;
    private Integer pickup;
    private Integer cancellation;

    public OccupancyByDateDto(){

    }
    public OccupancyByDateDto(Date occupancy_date,String name,Integer rooms,Float adr,Float revenue){
        this.occupancy_date = occupancy_date;
        this.name = name;
        this.rooms = rooms;
        this.adr = adr;
        this.revenue = revenue;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Float getAdr() {
        return adr;
    }

    public void setAdr(Float adr) {
        this.adr = adr;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOccupancy_date() {
        return occupancy_date;
    }

    public void setOccupancy_date(Date occupancy_date) {
        this.occupancy_date = occupancy_date;
    }
	public Integer getPickup() {
		return pickup;
	}
	public void setPickup(Integer pickup) {
		this.pickup = pickup;
	}
	public Integer getCancellation() {
		return cancellation;
	}
	public void setCancellation(Integer cancellation) {
		this.cancellation = cancellation;
	}
    
}

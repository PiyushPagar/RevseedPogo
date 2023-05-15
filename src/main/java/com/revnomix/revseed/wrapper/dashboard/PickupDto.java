package com.revnomix.revseed.wrapper.dashboard;

import java.util.Date;

public class PickupDto {
    private Date occupancyDate;
    private Integer pickup;
    private String ota_name;

    public PickupDto() {

    }

    public PickupDto(Date occupancyDate, Integer pickup,String ota_name) {
        this.occupancyDate = occupancyDate;
        this.pickup = pickup;
        this.ota_name = ota_name;
    }

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
    }

	public String getOta_name() {
		return ota_name;
	}

	public void setOta_name(String ota_name) {
		this.ota_name = ota_name;
	}
    
    
}

package com.revnomix.revseed.wrapper;

import org.joda.time.DateTime;

import java.util.Date;

public class OverrideFinalDto {

    public OverrideFinalDto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}



	private Integer id;
    private Date checkin_date;
    private Integer client_id;
    private Integer hotel_id;
    private Float rate;
    private Date update_date;
    private Integer roomId;
    private String strategy;

    public OverrideFinalDto(Integer id, Integer hotel_id, Integer client_id, Integer room_id, Date update_date,Date checkin_date,Float final_rate,String strategy){
        this.id = id;
        this.client_id = client_id;
        this.hotel_id = hotel_id;
        this.roomId = room_id;
        this.update_date = update_date;
        this.checkin_date = checkin_date;
        this.rate = final_rate;
        this.strategy = strategy;
    }
    
}

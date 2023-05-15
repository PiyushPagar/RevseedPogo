package com.revnomix.revseed.wrapper;

public class SeasonalityDto {
    private int id;
    private int client_id;
    private int hotel_id;
    private int number;
    private int start_date;
    private int end_date;
    private String season_name;
    private float max_price;
    private int max_capacity;
    private int cap_override;
    private float price_override;
    private float  min_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }


    public float getMin_price() {
        return min_price;
    }

    public void setMin_price(float min_price) {
        this.min_price = min_price;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getCap_override() {
        return cap_override;
    }

    public void setCap_override(int cap_override) {
        this.cap_override = cap_override;
    }

    public float getPrice_override() {
        return price_override;
    }

    public void setPrice_override(float price_override) {
        this.price_override = price_override;
    }

	public float getMax_price() {
		return max_price;
	}

	public void setMax_price(float max_price) {
		this.max_price = max_price;
	}
    
    
}

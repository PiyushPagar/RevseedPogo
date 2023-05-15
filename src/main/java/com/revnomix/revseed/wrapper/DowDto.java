package com.revnomix.revseed.wrapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DowDto {

    private Integer client_id;
    private String day;
    private Integer dow;
    private Integer hotel_id;
    private List<Integer> season_no;
    private List<Integer> season_id;
    private List<String> type;
    private Integer moddate;

    public String getDay() {
        return day;
    }

    public void setDay(AtomicInteger i, String day) {
        this.day = day;
    }

    public Integer getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }


    public List<Integer> getSeason_no() {
        return season_no;
    }

    public void setSeason_no(List<Integer> season_no) {
        this.season_no = season_no;
    }

    public List<Integer> getSeason_id() {
        return season_id;
    }

    public void setSeason_id(List<Integer> season_id) {
        this.season_id = season_id;
    }


    public Integer getModdate() {
        return moddate;
    }

    public void setModdate(Integer moddate) {
        this.moddate = moddate;
    }
}

package com.revnomix.revseed.wrapper;

import java.util.List;

public class CompetitorDto {


    private Integer client_id;
    private Integer hotel_id;
    private List<Integer> hotel_id1;




    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<Integer> getHotel_id1() {
        return hotel_id1;
    }

    public void setHotel_id1(List<Integer> hotel_id1) {
        this.hotel_id1 = hotel_id1;
    }


    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
}



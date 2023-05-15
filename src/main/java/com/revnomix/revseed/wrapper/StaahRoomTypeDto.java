package com.revnomix.revseed.wrapper;

import java.sql.Date;

public class StaahRoomTypeDto {
    private String staah_id;
    private String hotelName;
    private String roomTypeName;
    private String systemRoomType;
    private Integer capacity;
    private String source;

    private Integer staahId;
    private Integer staahRoomId;
    private Integer id;
    private Integer hotelId;
    private Integer clientId;
    private String status;
    private Date regDate;
    private double rate;
    private String name;
    private String ratePlanName;
    private Integer ratePlan;

    public StaahRoomTypeDto() {

    }

    public StaahRoomTypeDto(String staah_id, String hotelName, String roomTypeName,String systemRoomType, Integer capacity, String source) {
        this.staah_id = staah_id;
        this.hotelName = hotelName;
        this.roomTypeName = roomTypeName;
        this.systemRoomType = systemRoomType;
        this.capacity = capacity;
        this.source = source;
    }

    public StaahRoomTypeDto(Integer staah_id, String name, Integer staah_room_id, double rate, String rate_plan_name, Integer rate_plan) {
        this.staahId = staah_id;
        this.name = name;
        this.staahRoomId = staah_room_id;
        this.rate = rate;
        this.ratePlanName = rate_plan_name;
        this.ratePlan = rate_plan;
    }

    public String getStaah_id() {
        return staah_id;
    }

    public void setStaah_id(String staah_id) {
        this.staah_id = staah_id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public Integer getStaahId() {
        return staahId;
    }

    public void setStaahId(Integer staahId) {
        this.staahId = staahId;
    }

    public Integer getStaahRoomId() {
        return staahRoomId;
    }

    public void setStaahRoomId(Integer staahRoomId) {
        this.staahRoomId = staahRoomId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(Integer ratePlan) {
        this.ratePlan = ratePlan;

    }

    public String getSystemRoomType() {
        return systemRoomType;
    }

    public void setSystemRoomType(String systemRoomType) {
        this.systemRoomType = systemRoomType;
    }
}

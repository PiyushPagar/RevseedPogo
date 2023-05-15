package com.revnomix.revseed.wrapper;

import java.util.Date;

public class RoomTypeMappingsDto {
    private Integer capacity,client_id,hotel_id,priority,rt_id,rt_author,id;
    private String client_room_type,hotel_name,rt_description,rt_name,rt_status,status,system_name,type;
    private Date rt_regdate;

    public RoomTypeMappingsDto(Integer capacity, Integer client_id, Integer hotel_id, Integer priority, Integer rt_id, Integer rt_author, Integer id, String client_room_type, String hotel_name, String rt_description, String rt_name, String rt_status, String status, String system_name, String type, Date rt_regdate) {
        this.capacity = capacity;
        this.client_id = client_id;
        this.hotel_id = hotel_id;
        this.priority = priority;
        this.rt_id = rt_id;
        this.rt_author = rt_author;
        this.id = id;
        this.client_room_type = client_room_type;
        this.hotel_name = hotel_name;
        this.rt_description = rt_description;
        this.rt_name = rt_name;
        this.rt_status = rt_status;
        this.status = status;
        this.system_name = system_name;
        this.type = type;
        this.rt_regdate = rt_regdate;
    }
    
    public RoomTypeMappingsDto(Integer rt_id, String rt_name, String type) {
        this.rt_id = rt_id;
        this.system_name = rt_name;
        this.client_room_type = type;
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRt_id() {
        return rt_id;
    }

    public void setRt_id(Integer rt_id) {
        this.rt_id = rt_id;
    }

    public Integer getRt_author() {
        return rt_author;
    }

    public void setRt_author(Integer rt_author) {
        this.rt_author = rt_author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient_room_type() {
        return client_room_type;
    }

    public void setClient_room_type(String client_room_type) {
        this.client_room_type = client_room_type;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getRt_description() {
        return rt_description;
    }

    public void setRt_description(String rt_description) {
        this.rt_description = rt_description;
    }

    public String getRt_name() {
        return rt_name;
    }

    public void setRt_name(String rt_name) {
        this.rt_name = rt_name;
    }

    public Date getRt_regdate() {
        return rt_regdate;
    }

    public void setRt_regdate(Date rt_regdate) {
        this.rt_regdate = rt_regdate;
    }

    public String getRt_status() {
        return rt_status;
    }

    public void setRt_status(String rt_status) {
        this.rt_status = rt_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

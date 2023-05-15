package com.revnomix.revseed.wrapper;

public class StaahRateTypeDto {
    private String name;
    private String staahRateId;
    private String staahRoomId;
    private String staahRoomTypeName;


    public StaahRateTypeDto() {

    }

    public StaahRateTypeDto(String staahRoomId, String staahRoomTypeName) {
        this.staahRoomId = staahRoomId;
        this.staahRoomTypeName = staahRoomTypeName;
    }

    public StaahRateTypeDto(String staahRoomId, String name, String staahRateId, String staahRoomTypeName) {
        this.staahRoomId = staahRoomId;
        this.name = name;
        this.staahRateId = staahRateId;
        this.staahRoomTypeName = staahRoomTypeName;
    }

    public String getStaahRoomTypeName() {
        return staahRoomTypeName;
    }

    public void setStaahRoomTypeName(String staahRoomTypeName) {
        this.staahRoomTypeName = staahRoomTypeName;
    }

    public String getStaahRateId() {
        return staahRateId;
    }

    public void setStaahRateId(String staahRateId) {
        this.staahRateId = staahRateId;
    }

    public String getStaahRoomId() {
        return staahRoomId;
    }

    public void setStaahRoomId(String staahRoomId) {
        this.staahRoomId = staahRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.revnomix.revseed.wrapper;

public class RateShopRoomTypeMappingDto {
    private String name;
    private String type;
    private Integer systemRoomTypeId;

    public RateShopRoomTypeMappingDto(String name, String type, Integer systemRoomTypeId) {
        this.name = name;
        this.type = type;
        this.systemRoomTypeId = systemRoomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSystemRoomTypeId() {
        return systemRoomTypeId;
    }

    public void setSystemRoomTypeId(Integer systemRoomTypeId) {
        this.systemRoomTypeId = systemRoomTypeId;
    }
}

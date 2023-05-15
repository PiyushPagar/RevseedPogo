package com.revnomix.revseed.wrapper;

import java.util.List;

public class RoomTypeMappingsWrapper {
    private List<RoomTypeMappingsDto> roomtypes_data;
    private boolean status;

    public void setRoomtypes_data(List<RoomTypeMappingsDto> roomtypes_data) {
        this.roomtypes_data = roomtypes_data;
    }

    public List<RoomTypeMappingsDto> getRoomtypes_data() {
        return roomtypes_data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}

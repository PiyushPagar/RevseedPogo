package com.revnomix.revseed.wrapper.dashboard;

import com.revnomix.revseed.model.RoomTypes;
import com.revnomix.revseed.wrapper.CompetitorPricingDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DashboardCompetitorPricing {

    private List<String> competitorName;
    private Map<Date, Map<String, CompetitorPricingDto>> value;
    private List<RoomTypes> roomTypes;

    public List<String> getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(List<String> competitorName) {
        this.competitorName = competitorName;
    }

    public Map<Date, Map<String, CompetitorPricingDto>> getValue() {
        return value;
    }

    public void setValue(Map<Date, Map<String, CompetitorPricingDto>> value) {
        this.value = value;
    }

    public List<RoomTypes> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypes> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

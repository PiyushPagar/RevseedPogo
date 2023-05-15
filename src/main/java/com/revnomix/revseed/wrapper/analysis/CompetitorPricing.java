package com.revnomix.revseed.wrapper.analysis;

import com.revnomix.revseed.model.RoomTypes;

import java.util.*;

public class CompetitorPricing {

    private List<String> competitorName;
    private Map<Date, Map<String, CompetitorPricingAnalysisDto>> value;
    private List<RoomTypes> roomTypes;

    public List<String> getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(List<String> competitorName) {
        this.competitorName = competitorName;
    }

    public Map<Date, Map<String, CompetitorPricingAnalysisDto>> getValue() {
        return value;
    }

    public void setValue(Map<Date, Map<String, CompetitorPricingAnalysisDto>> value) {
        this.value = value;
    }

    public List<RoomTypes> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypes> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

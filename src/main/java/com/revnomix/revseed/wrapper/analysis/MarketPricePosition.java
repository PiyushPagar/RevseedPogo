package com.revnomix.revseed.wrapper.analysis;

import com.revnomix.revseed.model.RoomTypes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MarketPricePosition {

    private AnalysisOtaData analysisOtaData;
    private Map<String,List<Integer>> rangeByCategoriesDto;
    private List<RoomTypes> roomTypes;

    public List<RoomTypes> getRoomTypes() {
        return roomTypes;
    }

    public AnalysisOtaData getAnalysisOtaData() {
        return analysisOtaData;
    }

    public void setAnalysisOtaData(AnalysisOtaData analysisOtaData) {
        this.analysisOtaData = analysisOtaData;
    }

    public void setRoomTypes(List<RoomTypes> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public Map<String,List<Integer>> getRangeByCategoriesDto() {
        if (rangeByCategoriesDto == null){
            rangeByCategoriesDto = new LinkedHashMap<>();
        }
        return rangeByCategoriesDto;
    }

    public void setRangeByCategoriesDto(Map<String,List<Integer>> rangeByCategoriesDto) {
        this.rangeByCategoriesDto = rangeByCategoriesDto;
    }
}

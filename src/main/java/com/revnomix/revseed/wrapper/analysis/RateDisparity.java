package com.revnomix.revseed.wrapper.analysis;

import com.revnomix.revseed.model.RoomTypes;

import java.time.LocalDate;
import java.util.*;

public class RateDisparity {

    private Map<String, Map<String, OTAByCategoriesDto>>  data;
    private List<RoomTypes> roomTypes;
    private Set<String> otas;
    private List<String> categories;

    public List<String> getCategories() {
        if (categories == null){
            categories = new LinkedList<>();
        }
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Set<String> getOtas() {
        if (otas == null){
            otas = new LinkedHashSet<>();
        }
        return otas;
    }

    public void setOtas(Set<String> otas) {
        this.otas = otas;
    }

    public Map<String, Map<String, OTAByCategoriesDto>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, OTAByCategoriesDto>> data) {
        this.data = data;
    }

    public List<RoomTypes> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypes> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

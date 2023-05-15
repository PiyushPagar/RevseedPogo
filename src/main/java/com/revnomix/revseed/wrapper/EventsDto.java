package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.Events;

import java.util.List;

public class EventsDto {
    private Integer totalRows;
    private List<Events> events;

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<Events> getEvents() {
        return events;
    }
}

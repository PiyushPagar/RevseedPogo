package com.revnomix.revseed.wrapper.dashboard;

import java.util.HashMap;
import java.util.Map;

public class DashboardCompetitorDto {
    private String date;
    private String dow;
    private Map<String, Double> competitors;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public Map<String, Double> getCompetitors() {
        if (competitors == null) {
            competitors = new HashMap<>();
        }
        return competitors;
    }

    public void setCompetitors(Map<String, Double> competitors) {
        this.competitors = competitors;
    }
}

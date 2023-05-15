package com.revnomix.revseed.wrapper.analysis;

public class OTAByCategoriesDto {
    private String name;
    private String date;
    private Double min;

    public OTAByCategoriesDto(String name, String date, Double min) {
        this.name = name;
        this.date = date;
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }
}

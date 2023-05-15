package com.revnomix.revseed.wrapper.analysis;

public class RangeByCategoriesDto {
    private String date;
    private Double min;
    private Double max;

    public RangeByCategoriesDto(String date, Double min, Double max) {
        this.date = date;
        this.min = min;
        this.max = max;
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

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}

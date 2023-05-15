package com.revnomix.revseed.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RateDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    private Date rateDate;
    private Double rateOnCm;
    private Double recommended;

    public RateDto(Date rateDate, Double rateOnCm, Double recommended) {
        this.rateDate = rateDate;
        this.rateOnCm = rateOnCm;
        this.recommended = recommended;
    }

    public RateDto(Date rateDate, Double rateOnCm) {
        this.rateDate = rateDate;
        this.rateOnCm = rateOnCm;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public Double getRateOnCm() {
        return rateOnCm;
    }

    public void setRateOnCm(Double rateOnCm) {
        this.rateOnCm = rateOnCm;
    }

    public Double getRecommended() {
        return recommended;
    }

    public void setRecommended(Double recommended) {
        this.recommended = recommended;
    }
}

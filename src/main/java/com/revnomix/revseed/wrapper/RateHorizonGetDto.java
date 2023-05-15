package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.RateHorizon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RateHorizonGetDto {
    private Date date;
    private List<RateHorizon> rateHorizons = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<RateHorizon> getRateHorizons() {
        return rateHorizons;
    }

    public void setRateHorizons(List<RateHorizon> rateHorizons) {
        this.rateHorizons = rateHorizons;
    }
}

package com.revnomix.revseed.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class RmRatesDto implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy")
    private String hotelName,otaName;
    private Double minRate;
    public RmRatesDto(){

    }
    public RmRatesDto(String hotelName,String otaName,Double minRate){
        this.hotelName = hotelName;
        this.otaName = otaName;
        this.minRate = minRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }
}

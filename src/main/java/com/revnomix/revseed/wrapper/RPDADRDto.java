package com.revnomix.revseed.wrapper;

import java.io.Serializable;

public class RPDADRDto implements Serializable {
    private Integer DOW;
    private Integer total;
    private Integer Nights;
    private Integer RPD;
    private Integer ADR;
    private Integer APD;
    private Integer days;

    public RPDADRDto(Integer DOW, Integer total, Integer nights, Integer RPD, Integer ADR, Integer APD, Integer days) {
        this.DOW = DOW;
        this.total = total;
        Nights = nights;
        this.RPD = RPD;
        this.ADR = ADR;
        this.APD = APD;
        this.days = days;
    }

    public Integer getDOW() {
        return DOW;
    }

    public void setDOW(Integer DOW) {
        this.DOW = DOW;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNights() {
        return Nights;
    }

    public void setNights(Integer nights) {
        Nights = nights;
    }

    public Integer getRPD() {
        return RPD;
    }

    public void setRPD(Integer RPD) {
        this.RPD = RPD;
    }

    public Integer getADR() {
        return ADR;
    }

    public void setADR(Integer ADR) {
        this.ADR = ADR;
    }

    public Integer getAPD() {
        return APD;
    }

    public void setAPD(Integer APD) {
        this.APD = APD;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}

package com.revnomix.revseed.wrapper;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingsDto {

    private Date MaxDate;
    private Date MinDate;
    private Date ModDate;
    private Date RecDate;
    private Date inventoryDate;
    private Date rateDate;
    private Date hnfDate;
    private Date rateShopDate;
    private Date rateShopAvailable;
    private Integer recomRunToday;
    private String runcalibration;
    
    public BookingsDto(){

    }
    public BookingsDto(Date MaxDate,Date MinDate,Date ModDate,Date RecDate){
        this.MaxDate = MaxDate;
        this.MinDate = MinDate;
        this.ModDate = ModDate;
        this.RecDate = RecDate;
    }
    public Date getMinDate() {
        return MinDate;
    }

    public void setMinDate(Date minDate) {
        MinDate = minDate;
    }

    public Date getMaxDate() {
        return MaxDate;
    }

    public void setMaxDate(Date maxDate) {
        MaxDate = maxDate;
    }

    public Date getModDate() {
        return ModDate;
    }

    public void setModDate(Date modDate) {
        ModDate = modDate;
    }

    public Date getRecDate() {
        return RecDate;
    }

    public void setRecDate(Date recDate) {
        RecDate = recDate;
    }
    
    
    
    
}

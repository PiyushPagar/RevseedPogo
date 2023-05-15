package com.revnomix.revseed.wrapper;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OverrideStrageyDto implements Serializable {

    public OverrideStrageyDto(){

    }
    private Date date;
    private String overrideAlgo;
    private float overrideValue;
    private boolean overridden;
    private boolean isHorizon;

    public OverrideStrageyDto(Date date, String overrideAlgo, float overrideValue) {
        this.date = date;
        this.overrideAlgo = overrideAlgo;
        this.overrideValue = overrideValue;
    }
}

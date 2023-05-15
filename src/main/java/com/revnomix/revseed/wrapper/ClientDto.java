package com.revnomix.revseed.wrapper;

import java.util.Date;

import com.revnomix.revseed.model.Accounts;
import com.revnomix.revseed.model.CountryStateCity;
import com.revnomix.revseed.model.HnfType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto {
    private Integer id;
    private Integer hotelId;
    private String address;
    private String propertyName;
    private String currency;
    private CountryStateCity country;
    private String countryName;
    private CountryStateCity state;
    private String stateName;
    private CountryStateCity city;
    private String cityName;
    private Integer pinCode;
    private String flag;
    private String type;
    private String yield;
    private Integer capacity;
    private Double latitude;
    private Double longitude;
    private Integer accountManager;
    private String channelManager;
    private Integer cmHotel;
    private String cmUsername;
    private String cmPassword;
    private String cmMasterRoom;
    private String cmMasterRate;
    private Double minRate;
    private Accounts author;
    private String status;
    private String regDate;
    private Date systemToday;
    private String algo;
    private String runCalibration = "YES";
    private HnfType hnf;
    private String runRecommendation;
    private boolean ratePushEnable;
}

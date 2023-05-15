package com.revnomix.revseed.wrapper;

import java.io.Serializable;

public class HotelsdetailsDto implements Serializable {

    private String city;
    private String name;
    private String country;
    private String state;

    public HotelsdetailsDto(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}





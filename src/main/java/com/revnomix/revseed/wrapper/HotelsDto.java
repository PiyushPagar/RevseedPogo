package com.revnomix.revseed.wrapper;

import java.util.ArrayList;

import com.revnomix.revseed.model.Locations;

public class HotelsDto {

    private Integer id;
    private String address;
    private Locations city;
    private Locations country;
    private String latitude;
    private String longitude;
    private Integer rmCode;
    private String name;
    private Locations state;
    private String zip;
    private ArrayList<Integer> mergeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Locations getCity() {
        return city;
    }

    public void setCity(Locations city) {
        this.city = city;
    }

    public Locations getCountry() {
        return country;
    }

    public void setCountry(Locations country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getRmCode() {
        return rmCode;
    }

    public void setRmCode(Integer rmCode) {
        this.rmCode = rmCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locations getState() {
        return state;
    }

    public void setState(Locations state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

	public ArrayList<Integer> getMergeId() {
		return mergeId;
	}

	public void setMergeId(ArrayList<Integer> mergeId) {
		this.mergeId = mergeId;
	}
    
}

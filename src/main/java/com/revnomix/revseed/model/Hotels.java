package com.revnomix.revseed.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@NamedNativeQueries({
        @NamedNativeQuery(name = "Hotels.findRmCodeByClientId",
                query = " SELECT h.* FROM hotels h INNER JOIN clients c ON (c.hotel_id=h.id)\n" +
                        "                                                 AND c.id= :clientId    ",
                resultClass = Hotels.class
        ),
        @NamedNativeQuery(name = "Hotels.findByIdInOrderByFirstClient",
                query = " SELECT h.* FROM hotels h where id in (:ids) order by FIELD(NAME,:clientName) DESC   ",
                resultClass = Hotels.class
        ),
})

@Entity
@Table(name = "hotels")
public class Hotels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "rm_code")
    private Integer rmCode;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "state")
    private String state;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "status")
    private String status;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "author")
    private Integer author;

    @Transient
    private Float distance;
    
    @Transient
    private Integer clientId;

    public Hotels() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }



    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry() {
        return country;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }
    
    public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Transient
    public String getFormattedName(){
        return name + " ("+ rmCode+"), " + city+ ", " + country+ ", " +state;
    }

    @Transient
    public Float getDistance() {
        return distance;
    }

    @Transient
    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Hotels(Integer id, Integer rmCode, String name, String address, String city, Integer cityId, Integer stateId, String state, String zip, String country, Integer countryId, String latitude, String longitude, String status, Date regDate, Integer author) {
        this.id = id;
        this.rmCode = rmCode;
        this.name = name;
        this.address = address;
        this.city = city;
        this.cityId = cityId;
        this.state = state;
        this.stateId = stateId;
        this.zip = zip;
        this.country = country;
        this.countryId = countryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.regDate = regDate;
        this.author = author;
    }

    public Hotels(Integer id,Integer rmCode,String name,String address,String city,Integer cityId,Integer stateId,String state,String zip,String country,Integer countryId,String latitude,String longitude,String status,Date regDate,Integer author,Float distance) {
        this.id = id;
        this.rmCode = rmCode;
        this.name = name;
        this.address = address;
        this.city = city;
        this.cityId = cityId;
        this.state = state;
        this.stateId = stateId;
        this.zip = zip;
        this.country = country;
        this.countryId = countryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.regDate = regDate;
        this.author = author;
        this.distance = distance;
    }

}

package com.revnomix.revseed.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "clients")
public class Clients implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Column(name = "address")
    private String address;
    @Column(name = "property_name")
    private String propertyName;
    @Column(name = "currency")
    private String currency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country", referencedColumnName = "id", foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private CountryStateCity country;

    @Column(name = "country_name")
    private String countryName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state", referencedColumnName = "id", foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private CountryStateCity state;

    @Column(name = "state_name")
    private String stateName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city", referencedColumnName = "id", foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private CountryStateCity city;

    @Column(name = "city_name")
    private String cityName;
    @Column(name = "pincode")
    private Integer pincode;
    @Column(name = "flag")
    private String flag;
    @Column(name = "type")
    private String type;
    @Column(name = "yield")
    private String yield;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "account_manager")
    private Integer accountManager;
    @Column(name = "channel_manager")
    private String channelManager;
    @Column(name = "cm_hotel")
    private Integer cmHotel;
    @Column(name = "cm_username")
    private String cmUsername;
    @Column(name = "cm_password")
    private String cmPassword;
    @Column(name = "cm_master_room")
    private Long cmMasterRoom;
    @Column(name = "cm_master_rate")
    private Long cmMasterRate;
    @Column(name = "min_rate")
    private Double minRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author", referencedColumnName = "accountId", insertable = false, updatable = true, foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Accounts author;

    @Column(name = "status")
    private String status;

    @Column(name = "regDate")
    private String regDate;

    @Column(name = "system_today")
    private Date systemToday;

    @Column(name = "use_algo")
    private String Algo;

    @Column(name = "run_calibration", columnDefinition = "varchar(255) default 'YES'")
    private String runCalibration = "YES";

    @Column(name = "hnf")
    @Access(AccessType.PROPERTY)
    @Enumerated(EnumType.STRING)
    private HnfType hnf;

    @Column(name = "run_recommendation")
    private String runRecommendation;

    @Column(name = "rate_push_enable")
    private boolean ratePushEnable;
    
    @JsonInclude()
    @Transient
    private String accountManagerName;
    
    @JsonInclude()
    @Transient
    private Integer rmcode;
    
    @Transient
    private String isMax;

    public boolean isRatePushEnable() {
        return ratePushEnable;
    }

    public void setRatePushEnable(boolean ratePushEnable) {
        this.ratePushEnable = ratePushEnable;
    }

    public String getRunCalibration() { return runCalibration; }

    public void setRunCalibration(String runCalibration) { this.runCalibration = runCalibration; }

    public Date getSystemToday() {
        return systemToday;
    }

    public void setSystemToday(Date systemToday) {
        this.systemToday = systemToday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    
    public CountryStateCity getCountry() {
        return country;
    }

    public void setCountry(CountryStateCity country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryStateCity getState() {
        return state;
    }

    public void setState(CountryStateCity state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Integer accountManager) {
        this.accountManager = accountManager;
    }

    public String getChannelManager() {
        return channelManager;
    }

    public void setChannelManager(String channelManager) {
        this.channelManager = channelManager;
    }

    public Integer getCmHotel() {
        return cmHotel;
    }

    public void setCmHotel(Integer cmHotel) {
        this.cmHotel = cmHotel;
    }

    public String getCmUsername() {
        return cmUsername;
    }

    public void setCmUsername(String cmUsername) {
        this.cmUsername = cmUsername;
    }

    public String getCmPassword() {
        return cmPassword;
    }

    public void setCmPassword(String cmPassword) {
        this.cmPassword = cmPassword;
    }

    public Long getCmMasterRoom() {
        return cmMasterRoom;
    }

    public void setCmMasterRoom(Long cmMasterRoom) {
        this.cmMasterRoom = cmMasterRoom;
    }

    public Long getCmMasterRate() {
        return cmMasterRate;
    }

    public void setCmMasterRate(Long cmMasterRate) {
        this.cmMasterRate = cmMasterRate;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public Accounts getAuthor() {
        return author;
    }

    public void setAuthor(Accounts author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getAlgo() {
        return Algo;
    }

    public void setAlgo(String algo) {
        Algo = algo;
    }

    public CountryStateCity getCity() {
        return city;
    }

    public void setCity(CountryStateCity city) {
        this.city = city;
    }


    public HnfType getHnf() {
        return hnf;
    }

    public void setHnf(HnfType hnf) {
        this.hnf = hnf;
    }

    public String getRunRecommendation() {
        return runRecommendation;
    }

    public void setRunRecommendation(String runRecommendation) {
        this.runRecommendation = runRecommendation;
    }

	public String getAccountManagerName() {
		return accountManagerName;
	}

	public void setAccountManagerName(String accountManagerName) {
		this.accountManagerName = accountManagerName;
	}
    
	public String getIsMax() {
		return isMax;
	}

	public void setIsMax(String isMax) {
		this.isMax = isMax;
	}

	public Integer getRmcode() {
		return rmcode;
	}

	public void setRmcode(Integer rmcode) {
		this.rmcode = rmcode;
	}
		
}

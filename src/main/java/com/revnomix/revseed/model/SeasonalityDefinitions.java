package com.revnomix.revseed.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "seasonality_definitions")
public class SeasonalityDefinitions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "season_name")
    private String seasonName;

    @Column(name = "number")
    private Integer number;

    @Column(name = "start_week")
    private Integer startWeek;

    @Column(name = "end_week")
    private Integer endWeek;

    @Column(name = "max_capacity")
    private Integer maxCapacity;

    @Column(name = "cap_override")
    private Integer capOverride;

    @Column(name = "price_override")
    private Float priceOverride;

    @Column(name = "min_price")
    private Float minPrice;
    
    @Column(name = "max_price")
    private Float maxPrice;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "author")
    private Integer author;

    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMinCapacity() {
    }

    public Integer getCapOverride() {
        return capOverride;
    }

    public void setCapOverride(Integer capOverride) {
        this.capOverride = capOverride;
    }

    public Float getPriceOverride() {
        return priceOverride;
    }

    public void setPriceOverride(Float priceOverride) {
        this.priceOverride = priceOverride;
    }

	public Float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}
    
}

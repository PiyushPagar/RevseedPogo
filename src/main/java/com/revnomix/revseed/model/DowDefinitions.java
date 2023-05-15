package com.revnomix.revseed.model;

import com.revnomix.revseed.wrapper.DowDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "dow_definitions")
public class DowDefinitions extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "season_id")
    private Integer seasonId;

    @Column(name = "season_no")
    private Integer seasonNo;

    @Column(name = "day")
    private String day;

    @Column(name = "dow")
    private Integer dow;

    @Column(name = "type")
    private String type;

    @Column(name = "author")
    private Integer author;

    @Column(name = "moddate")
    private Date modDate;

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

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getSeasonNo() {
        return seasonNo;
    }

    public void setSeasonNo(Integer seasonNo) {
        this.seasonNo = seasonNo;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getDow() {
        return dow;
    }

    public void setDow(Integer dow) {
        this.dow = dow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public void setSeasonNo(List<SeasonalityDefinitions> allById) {
    }

    public void setSeasonNo(Optional<SeasonalityDefinitions> byId) {
    }

    public void setDay(int d) {
    }
}

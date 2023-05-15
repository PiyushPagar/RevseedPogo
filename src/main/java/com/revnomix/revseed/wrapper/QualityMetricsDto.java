package com.revnomix.revseed.wrapper;

import java.util.Date;


public class QualityMetricsDto {

    public QualityMetricsDto(){

    }
    private Integer id;
    private Integer hotelId;
    private Integer client_id;
    private Integer ota;
    private String name;
    private String parameter;
    private double hotelScore;
    private double maxScore;
    private double quantity;
    private Date regDate;
    private String hotelName;
    private String domainName;

    public QualityMetricsDto(Integer id, Integer hotel_id, Integer client_id, Integer ota, String qmName, String parameter, Double hotel_score, Double max_score, Double quantity, String hotelName, String domain_name){        this.id = id;
        this.hotelId = hotel_id;
        this.client_id = client_id;
        this.ota = ota;
        this.name = qmName;
        this.parameter = parameter;
        this.hotelScore = hotel_score;
        this.maxScore = max_score;
        this.quantity = quantity;
        this.hotelName = hotelName;
        this.domainName = domain_name;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
    
    public Integer getOta() {
        return ota;
    }

    public void setOta(Integer ota) {
        this.ota = ota;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getHotelScore() {
        return hotelScore;
    }

    public void setHotelScore(double hotelScore) {
        this.hotelScore = hotelScore;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

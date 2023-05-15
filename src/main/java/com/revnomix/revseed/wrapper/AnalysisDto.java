package com.revnomix.revseed.wrapper;

import org.joda.time.DateTime;

import javax.persistence.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class AnalysisDto implements Serializable {
    @Transient
    private final Integer clientId;
    @Transient
    private final DateTime startDate;
    @Transient
    private final DateTime endDate;
    private final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private Map<String,Object> arrival_los = new HashMap<>();
    private Map<String,Object> arrival_los_ly = new HashMap<>();
    private Map<String,Object> rpd_adr = new HashMap<>();
    private Map<String,Object> rpd_adr_ly = new HashMap<>();
    private Map<String,Object> dow_contrib = new HashMap<>();
    private Map<String,Object> pace_analysis = new HashMap<>();
    private Map<String,Object> rv_matrix = new HashMap<>();
    private Map<String,Object> room_nights_rate_band_ty = new HashMap<>();
    private Map<String,Object> room_nights_rate_band_ly = new HashMap<>();
    private Map<String,Object> rate_band_by_dow_ty = new HashMap<>();
    private Map<String,Object> rate_band_by_dow_ly = new HashMap<>();

    public AnalysisDto(Integer clientId, Date startDate, Date endDate) {
        this.clientId = clientId;
        this.startDate = new DateTime(startDate);
        this.endDate = new DateTime(endDate);
        String tyRange =  df.format(startDate)+" to "+df.format(endDate);
        String lyRange = df.format(this.startDate.plusYears(-1).toDate())+" to "+df.format(this.endDate.plusYears(-1).toDate());
        List<String> days = Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        updateArrivalLos("categories",days);
        updateArrivalLos("subtitle",tyRange);
        updateArrivalLosLy("categories",days);
        updateArrivalLosLy("subtitle",lyRange);
        updateRpdADR("categories",days);
        updateRpdADR("subtitle",tyRange);
        updateRpdADRLy("categories",days);
        updateRpdADRLy("subtitle",tyRange);
        updateDOWContrib("categories",days);
        updateDOWContrib("subtitle",tyRange);
        updatePaceAnalysis("",Arrays.asList(0, 20, 40, 60, 80, 100));
        updatePaceAnalysis("subtitle",tyRange);
        updateRvMatrix("subtitle",tyRange);
    }

    public void updateRvMatrix(String key, Object value) {
        rv_matrix.put(key,value);
    }

    public void updatePaceAnalysis(String key, Object value) {
        pace_analysis.put(key,value);
    }

    public Map<String, Object> getArrival_los() {
        return arrival_los;
    }

    public void setArrival_los(Map<String, Object> arrival_los) {
        this.arrival_los = arrival_los;
    }

    public Map<String, Object> getArrival_los_ly() {
        return arrival_los_ly;
    }

    public void setArrival_los_ly(Map<String, Object> arrival_los_ly) {
        this.arrival_los_ly = arrival_los_ly;
    }

    public Map<String, Object> getRpd_adr() {
        return rpd_adr;
    }

    public void setRpd_adr(Map<String, Object> rpd_adr) {
        this.rpd_adr = rpd_adr;
    }

    public Map<String, Object> getRpd_adr_ly() {
        return rpd_adr_ly;
    }

    public void setRpd_adr_ly(Map<String, Object> rpd_adr_ly) {
        this.rpd_adr_ly = rpd_adr_ly;
    }

    public Map<String, Object> getDow_contrib() {
        return dow_contrib;
    }

    public void setDow_contrib(Map<String, Object> dow_contrib) {
        this.dow_contrib = dow_contrib;
    }

    public Map<String, Object> getPace_analysis() {
        return pace_analysis;
    }

    public void setPace_analysis(Map<String, Object> pace_analysis) {
        this.pace_analysis = pace_analysis;
    }

    public Map<String, Object> getRv_matrix() {
        return rv_matrix;
    }

    public void setRv_matrix(Map<String, Object> rv_matrix) {
        this.rv_matrix = rv_matrix;
    }

    public Map<String, Object> getRoom_nights_rate_band_ty() {
        return room_nights_rate_band_ty;
    }

    public void setRoom_nights_rate_band_ty(Map<String, Object> room_nights_rate_band_ty) {
        this.room_nights_rate_band_ty = room_nights_rate_band_ty;
    }

    public Map<String, Object> getRoom_nights_rate_band_ly() {
        return room_nights_rate_band_ly;
    }

    public void setRoom_nights_rate_band_ly(Map<String, Object> room_nights_rate_band_ly) {
        this.room_nights_rate_band_ly = room_nights_rate_band_ly;
    }

    public Map<String, Object> getRate_band_by_dow_ty() {
        return rate_band_by_dow_ty;
    }

    public void setRate_band_by_dow_ty(Map<String, Object> rate_band_by_dow_ty) {
        this.rate_band_by_dow_ty = rate_band_by_dow_ty;
    }

    public Map<String, Object> getRate_band_by_dow_ly() {
        return rate_band_by_dow_ly;
    }

    public void setRate_band_by_dow_ly(Map<String, Object> rate_band_by_dow_ly) {
        this.rate_band_by_dow_ly = rate_band_by_dow_ly;
    }


    public void updateDOWContrib(String key, Object value) {
        dow_contrib.put(key,value);
    }

    public void updateRpdADRLy(String key, Object value) {
        rpd_adr_ly.put(key,value);
    }

    public void updateRpdADR(String key, Object value) {
        rpd_adr.put(key,value);
    }


    public void updateArrivalLos(String key, Object value) {
        arrival_los.put(key,value);
    }
    public void updateArrivalLosLy(String key, Object value) {
        arrival_los_ly.put(key,value);
    }

}

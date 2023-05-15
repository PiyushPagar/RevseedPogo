package com.revnomix.revseed.wrapper.dashboard;

import java.util.LinkedHashMap;
import java.util.Map;


public class CummulativeGraphDto {

    private Map<String,Double> thisYearRevenuePickup;
    private Map<String, Integer> thisYearRoomSoldPickup;
    private Map<String,Double> lastYearRevenuePickup;
    private Map<String, Integer> lastYearRoomSoldPickup;
    private Map<String,Double> thisYearmovingAvgRevenuePickup;
    private Map<String, Integer> thisYearmovingAvgrRoomSoldPickup;
    private Map<String,Double> lastYearmovingAvgRevenuePickup;
    private Map<String, Integer> lastYearmovingAvgrRoomSoldPickup;
    
	public Map<String, Double> getThisYearRevenuePickup() {
		if (this.thisYearRevenuePickup ==null){
            this.thisYearRevenuePickup = new LinkedHashMap<>();
        }
		return thisYearRevenuePickup;
	}
	public void setThisYearRevenuePickup(Map<String, Double> thisYearRevenuePickup) {
		
		this.thisYearRevenuePickup = thisYearRevenuePickup;
	}
	public Map<String, Integer> getThisYearRoomSoldPickup() {
		if (this.thisYearRoomSoldPickup ==null){
            this.thisYearRoomSoldPickup = new LinkedHashMap<>();
        }
		return thisYearRoomSoldPickup;
	}
	public void setThisYearRoomSoldPickup(Map<String, Integer> thisYearRoomSoldPickup) {
		this.thisYearRoomSoldPickup = thisYearRoomSoldPickup;
	}
	public Map<String, Double> getLastYearRevenuePickup() {
		if (this.lastYearRevenuePickup ==null){
            this.lastYearRevenuePickup = new LinkedHashMap<>();
        }
		return lastYearRevenuePickup;
	}
	public void setLastYearRevenuePickup(Map<String, Double> lastYearRevenuePickup) {
		this.lastYearRevenuePickup = lastYearRevenuePickup;
	}
	public Map<String, Integer> getLastYearRoomSoldPickup() {
		if (this.lastYearRoomSoldPickup ==null){
            this.lastYearRoomSoldPickup = new LinkedHashMap<>();
        }
		return lastYearRoomSoldPickup;
	}
	public void setLastYearRoomSoldPickup(Map<String, Integer> lastYearRoomSoldPickup) {
		this.lastYearRoomSoldPickup = lastYearRoomSoldPickup;
	}
	public Map<String, Double> getThisYearmovingAvgRevenuePickup() {
		if (this.thisYearmovingAvgRevenuePickup ==null){
            this.thisYearmovingAvgRevenuePickup = new LinkedHashMap<>();
        }
		return thisYearmovingAvgRevenuePickup;
	}
	public void setThisYearmovingAvgRevenuePickup(Map<String, Double> thisYearmovingAvgRevenuePickup) {
		this.thisYearmovingAvgRevenuePickup = thisYearmovingAvgRevenuePickup;
	}
	public Map<String, Integer> getThisYearmovingAvgrRoomSoldPickup() {
		if (this.thisYearmovingAvgrRoomSoldPickup ==null){
            this.thisYearmovingAvgrRoomSoldPickup = new LinkedHashMap<>();
        }
		return thisYearmovingAvgrRoomSoldPickup;
	}
	public void setThisYearmovingAvgrRoomSoldPickup(Map<String, Integer> thisYearmovingAvgrRoomSoldPickup) {
		this.thisYearmovingAvgrRoomSoldPickup = thisYearmovingAvgrRoomSoldPickup;
	}
	public Map<String, Double> getLastYearmovingAvgRevenuePickup() {
		if (this.lastYearmovingAvgRevenuePickup ==null){
            this.lastYearmovingAvgRevenuePickup = new LinkedHashMap<>();
        }
		return lastYearmovingAvgRevenuePickup;
	}
	public void setLastYearmovingAvgRevenuePickup(Map<String, Double> lastYearmovingAvgRevenuePickup) {
		this.lastYearmovingAvgRevenuePickup = lastYearmovingAvgRevenuePickup;
	}
	public Map<String, Integer> getLastYearmovingAvgrRoomSoldPickup() {
		if (this.lastYearmovingAvgrRoomSoldPickup ==null){
            this.lastYearmovingAvgrRoomSoldPickup = new LinkedHashMap<>();
        }
		return lastYearmovingAvgrRoomSoldPickup;
	}
	public void setLastYearmovingAvgrRoomSoldPickup(Map<String, Integer> lastYearmovingAvgrRoomSoldPickup) {
		this.lastYearmovingAvgrRoomSoldPickup = lastYearmovingAvgrRoomSoldPickup;
	}

    
    
    
}

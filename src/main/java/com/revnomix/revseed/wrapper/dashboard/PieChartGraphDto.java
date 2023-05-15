package com.revnomix.revseed.wrapper.dashboard;

import java.util.LinkedHashMap;
import java.util.Map;

import com.revnomix.revseed.wrapper.OtaPerformanceDto;

public class PieChartGraphDto {

	private Map<String, Integer> todaysRoomPickupByOta;
	private Map<String, Integer> yesterdayRoomPickupByOta;
	private Map<String, Integer> thisMonthRoomPickupByOta;
	private Map<String, Integer> lastMonthRoomPickupByOta;
	
	private Map<String, Double> todaysRevenuePickupByOta;
	private Map<String, Double> yesterdayRevenuePickupByOta;
	private Map<String, Double> thisMonthRevenuePickupByOta;
	private Map<String, Double> lastMonthRevenuePickupByOta;
	
	private Map<String, Integer> todaysRoomSoldByOta;
	private Map<String, Integer> yesterdayRoomSoldByOta;
	private Map<String, Integer> thisMonthRoomSoldByOta;
	private Map<String, Integer> lastMonthRoomSoldByOta;
	
	private Map<String, OtaPerformanceDto> todaysPerformanceByOta;
	private Map<String, OtaPerformanceDto> yesterdayPerformanceByOta;
	private Map<String, OtaPerformanceDto> thisMonthPerformanceByOta;
	private Map<String, OtaPerformanceDto> lastMonthPerformanceByOta;
	private Map<String, Double> todaysADRPickupByOta;
	
	
	public Map<String, Integer> getTodaysRoomPickupByOta() {
		if (this.todaysRoomPickupByOta ==null){
            this.todaysRoomPickupByOta = new LinkedHashMap<>();
        }
		return todaysRoomPickupByOta;
	}
	public void setTodaysRoomPickupByOta(Map<String, Integer> todaysRoomPickupByOta) {
		this.todaysRoomPickupByOta = todaysRoomPickupByOta;
	}
	public Map<String, Integer> getYesterdayRoomPickupByOta() {
		if (this.yesterdayRoomPickupByOta ==null){
            this.yesterdayRoomPickupByOta = new LinkedHashMap<>();
        }
		return yesterdayRoomPickupByOta;
	}
	public void setYesterdayRoomPickupByOta(Map<String, Integer> yesterdayRoomPickupByOta) {
		this.yesterdayRoomPickupByOta = yesterdayRoomPickupByOta;
	}
	public Map<String, Integer> getThisMonthRoomPickupByOta() {
		if (this.thisMonthRoomPickupByOta ==null){
            this.thisMonthRoomPickupByOta = new LinkedHashMap<>();
        }
		return thisMonthRoomPickupByOta;
	}
	public void setThisMonthRoomPickupByOta(Map<String, Integer> thisMonthRoomPickupByOta) {
		this.thisMonthRoomPickupByOta = thisMonthRoomPickupByOta;
	}
	public Map<String, Integer> getLastMonthRoomPickupByOta() {
		if (this.lastMonthRoomPickupByOta ==null){
            this.lastMonthRoomPickupByOta = new LinkedHashMap<>();
        }
		return lastMonthRoomPickupByOta;
	}
	public void setLastMonthRoomPickupByOta(Map<String, Integer> lastMonthRoomPickupByOta) {
		this.lastMonthRoomPickupByOta = lastMonthRoomPickupByOta;
	}
	public Map<String, Double> getTodaysRevenuePickupByOta() {
		if (this.todaysRevenuePickupByOta ==null){
            this.todaysRevenuePickupByOta = new LinkedHashMap<>();
        }
		return todaysRevenuePickupByOta;
	}
	public void setTodaysRevenuePickupByOta(Map<String, Double> todaysRevenuePickupByOta) {
		this.todaysRevenuePickupByOta = todaysRevenuePickupByOta;
	}
	public Map<String, Double> getYesterdayRevenuePickupByOta() {
		if (this.yesterdayRevenuePickupByOta ==null){
            this.yesterdayRevenuePickupByOta = new LinkedHashMap<>();
        }
		return yesterdayRevenuePickupByOta;
	}
	public void setYesterdayRevenuePickupByOta(Map<String, Double> yesterdayRevenuePickupByOta) {
		this.yesterdayRevenuePickupByOta = yesterdayRevenuePickupByOta;
	}
	public Map<String, Double> getThisMonthRevenuePickupByOta() {
		if (this.thisMonthRevenuePickupByOta ==null){
            this.thisMonthRevenuePickupByOta = new LinkedHashMap<>();
        }
		return thisMonthRevenuePickupByOta;
	}
	public void setThisMonthRevenuePickupByOta(Map<String, Double> thisMonthRevenuePickupByOta) {
		this.thisMonthRevenuePickupByOta = thisMonthRevenuePickupByOta;
	}
	public Map<String, Double> getLastMonthRevenuePickupByOta() {
		if (this.lastMonthRevenuePickupByOta ==null){
            this.lastMonthRevenuePickupByOta = new LinkedHashMap<>();
        }
		return lastMonthRevenuePickupByOta;
	}
	public void setLastMonthRevenuePickupByOta(Map<String, Double> lastMonthRevenuePickupByOta) {
		this.lastMonthRevenuePickupByOta = lastMonthRevenuePickupByOta;
	}
	public Map<String, Integer> getTodaysRoomSoldByOta() {
		if (this.todaysRoomSoldByOta ==null){
            this.todaysRoomSoldByOta = new LinkedHashMap<>();
        }
		return todaysRoomSoldByOta;
	}
	public void setTodaysRoomSoldByOta(Map<String, Integer> todaysRoomSoldByOta) {
		this.todaysRoomSoldByOta = todaysRoomSoldByOta;
	}
	public Map<String, Integer> getYesterdayRoomSoldByOta() {
		if (this.yesterdayRoomSoldByOta ==null){
            this.yesterdayRoomSoldByOta = new LinkedHashMap<>();
        }
		return yesterdayRoomSoldByOta;
	}
	public void setYesterdayRoomSoldByOta(Map<String, Integer> yesterdayRoomSoldByOta) {
		this.yesterdayRoomSoldByOta = yesterdayRoomSoldByOta;
	}
	public Map<String, Integer> getThisMonthRoomSoldByOta() {
		if (this.thisMonthRoomSoldByOta ==null){
            this.thisMonthRoomSoldByOta = new LinkedHashMap<>();
        }
		return thisMonthRoomSoldByOta;
	}
	public void setThisMonthRoomSoldByOta(Map<String, Integer> thisMonthRoomSoldByOta) {
		this.thisMonthRoomSoldByOta = thisMonthRoomSoldByOta;
	}
	public Map<String, Integer> getLastMonthRoomSoldByOta() {
		if (this.lastMonthRoomSoldByOta ==null){
            this.lastMonthRoomSoldByOta = new LinkedHashMap<>();
        }
		return lastMonthRoomSoldByOta;
	}
	public void setLastMonthRoomSoldByOta(Map<String, Integer> lastMonthRoomSoldByOta) {
		this.lastMonthRoomSoldByOta = lastMonthRoomSoldByOta;
	}
	public Map<String, OtaPerformanceDto> getTodaysPerformanceByOta() {
		if (this.todaysPerformanceByOta ==null){
            this.todaysPerformanceByOta = new LinkedHashMap<>();
        }
		return todaysPerformanceByOta;
	}
	public void setTodaysPerformanceByOta(Map<String, OtaPerformanceDto> todaysPerformanceByOta) {
		this.todaysPerformanceByOta = todaysPerformanceByOta;
	}
	public Map<String, OtaPerformanceDto> getYesterdayPerformanceByOta() {
		if (this.yesterdayPerformanceByOta ==null){
            this.yesterdayPerformanceByOta = new LinkedHashMap<>();
        }
		return yesterdayPerformanceByOta;
	}
	public void setYesterdayPerformanceByOta(Map<String, OtaPerformanceDto> yesterdayPerformanceByOta) {
		this.yesterdayPerformanceByOta = yesterdayPerformanceByOta;
	}
	public Map<String, OtaPerformanceDto> getThisMonthPerformanceByOta() {
		if (this.thisMonthPerformanceByOta ==null){
            this.thisMonthPerformanceByOta = new LinkedHashMap<>();
        }
		return thisMonthPerformanceByOta;
	}
	public void setThisMonthPerformanceByOta(Map<String, OtaPerformanceDto> thisMonthPerformanceByOta) {
		this.thisMonthPerformanceByOta = thisMonthPerformanceByOta;
	}
	public Map<String, OtaPerformanceDto> getLastMonthPerformanceByOta() {
		if (this.lastMonthPerformanceByOta ==null){
            this.lastMonthPerformanceByOta = new LinkedHashMap<>();
        }
		return lastMonthPerformanceByOta;
	}
	public void setLastMonthPerformanceByOta(Map<String, OtaPerformanceDto> lastMonthPerformanceByOta) {
		this.lastMonthPerformanceByOta = lastMonthPerformanceByOta;
	}
	public Map<String, Double> getTodaysADRPickupByOta() {
		if (this.todaysADRPickupByOta ==null){
            this.todaysADRPickupByOta = new LinkedHashMap<>();
        }
		return todaysADRPickupByOta;
	}
	public void setTodaysADRPickupByOta(Map<String, Double> todaysADRPickupByOta) {
		this.todaysADRPickupByOta = todaysADRPickupByOta;
	}
	
	
	
}

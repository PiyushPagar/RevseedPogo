package com.revnomix.revseed.wrapper.dashboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;

import java.io.Serializable;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DashboardOtaPerformanceDto  implements Serializable {
    
    private OtaPerformanceDto todaysOta;
    private OtaPerformanceDto yesterdaysOta;
    private OtaPerformanceDto thisMonthOta;
    private OtaPerformanceDto lastMontOta;

    private List<DashboardOverviewDto> nextTenDaysOtaList;
    private Map<String,Double> lastMonthRevenuePickup;
    private Map<String, Integer> lastMonthRoomSoldPickup;

    private Map<String,Double> lastYearRevenuePickup;
    private Map<String, Integer> lastYearRoomSoldPickup;
    private Map<String,Double> lastMonthADRPickup;

    //current
    private Map<String,Double> currentRevenueTrend;
    private Map<String, Integer> currentRoomSoldTrend;
    private Map<String, Double> currentAdrTrend;
    private Map<String, Integer> availableCapacity;

    private Map<String,Double> lastYearCurrentRevenueTrend;
    private Map<String, Integer> lastYearCurrentRoomSoldTrend;
    private Map<String, Double> lastYearAdrTrend;
    
    private Map<String,Double> sameTimelastYearCurrentRevenueTrend;
    private Map<String, Integer> sameTimelastYearCurrentRoomSoldTrend;
    private Map<String, Double> sameTimelastYearAdrTrend;

    //byOta
    private Map<String,Double> currentRevenueTrendByOta;
    private Map<String, Integer> currentRoomSoldTrendByOta;
    private Map<String, Double> currentAdrTrendByOta;

    private Map<String,Double> lastYearCurrentRevenueTrendByOta;
    private Map<String, Integer> lastYearCurrentRoomSoldTrendByOta;
    private Map<String, Double> lastYearAdrTrendByOta;
    
    private Map<String,Double> sameTimelastYearCurrentRevenueTrendByOta;
    private Map<String, Integer> sameTimelastYearCurrentRoomSoldTrendByOta;
    private Map<String, Double> sameTimelastYearAdrTrendByOta;
    
    private Map<String, Double> currentYearRates;  
    
    
    

    public OtaPerformanceDto getTodaysOta() {
        return todaysOta;
    }

    public void setTodaysOta(OtaPerformanceDto todaysOta) {
        this.todaysOta = todaysOta;
    }

    public OtaPerformanceDto getYesterdaysOta() {
        return yesterdaysOta;
    }

    public void setYesterdaysOta(OtaPerformanceDto yesterdaysOta) {
        this.yesterdaysOta = yesterdaysOta;
    }

    public OtaPerformanceDto getThisMonthOta() {
        return thisMonthOta;
    }

    public void setThisMonthOta(OtaPerformanceDto thisMonthOta) {
        this.thisMonthOta = thisMonthOta;
    }

    public OtaPerformanceDto getLastMontOta() {
        return lastMontOta;
    }

    public void setLastMontOta(OtaPerformanceDto lastMontOta) {
        this.lastMontOta = lastMontOta;
    }

    public List<DashboardOverviewDto> getNextTenDaysOtaList() {
        if (this.nextTenDaysOtaList==null){
            this.nextTenDaysOtaList= new ArrayList<>();
        }
        return nextTenDaysOtaList;
    }

    public void setNextTenDaysOtaList(List<DashboardOverviewDto> nextTenDaysOtaList) {
        this.nextTenDaysOtaList = nextTenDaysOtaList;
    }

    public Map<String, Double> getLastMonthRevenuePickup() {
        if (this.lastMonthRevenuePickup ==null){
            this.lastMonthRevenuePickup = new LinkedHashMap<>();
        }
        return lastMonthRevenuePickup;
    }

    public void setLastMonthRevenuePickup(Map<String, Double> lastMonthRevenuePickup) {
        this.lastMonthRevenuePickup = lastMonthRevenuePickup;
    }

    public Map<String, Integer> getLastMonthRoomSoldPickup() {
        if (this.lastMonthRoomSoldPickup ==null){
            this.lastMonthRoomSoldPickup = new LinkedHashMap<>();
        }
        return lastMonthRoomSoldPickup;
    }

    public void setLastMonthRoomSoldPickup(Map<String, Integer> lastMonthRoomSoldPickup) {
        this.lastMonthRoomSoldPickup = lastMonthRoomSoldPickup;
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


    public Map<String, Double> getCurrentRevenueTrend() {
        if (this.currentRevenueTrend ==null){
            this.currentRevenueTrend = new LinkedHashMap<>();
        }
        return currentRevenueTrend;
    }

    public void setCurrentRevenueTrend(Map<String, Double> currentRevenueTrend) {
        this.currentRevenueTrend = currentRevenueTrend;
    }

    public Map<String, Integer> getCurrentRoomSoldTrend() {
        if (this.currentRoomSoldTrend ==null){
            this.currentRoomSoldTrend = new LinkedHashMap<>();
        }
        return currentRoomSoldTrend;
    }

    public void setCurrentRoomSoldTrend(Map<String, Integer> currentRoomSoldTrend) {
        this.currentRoomSoldTrend = currentRoomSoldTrend;
    }

    public Map<String, Double> getLastYearCurrentRevenueTrend() {
        if (this.lastYearCurrentRevenueTrend ==null){
            this.lastYearCurrentRevenueTrend = new LinkedHashMap<>();
        }
        return lastYearCurrentRevenueTrend;
    }

    public void setLastYearCurrentRevenueTrend(Map<String, Double> lastYearCurrentRevenueTrend) {
        this.lastYearCurrentRevenueTrend = lastYearCurrentRevenueTrend;
    }

    public Map<String, Integer> getLastYearCurrentRoomSoldTrend() {
        if (this.lastYearCurrentRoomSoldTrend ==null){
            this.lastYearCurrentRoomSoldTrend = new LinkedHashMap<>();
        }
        return lastYearCurrentRoomSoldTrend;
    }

    public void setLastYearCurrentRoomSoldTrend(Map<String, Integer> lastYearCurrentRoomSoldTrend) {
        this.lastYearCurrentRoomSoldTrend = lastYearCurrentRoomSoldTrend;
    }

    public Map<String, Double> getCurrentRevenueTrendByOta() {
        if (this.currentRevenueTrendByOta ==null){
            this.currentRevenueTrendByOta = new LinkedHashMap<>();
        }
        return currentRevenueTrendByOta;
    }

    public void setCurrentRevenueTrendByOta(Map<String, Double> currentRevenueTrendByOta) {
        this.currentRevenueTrendByOta = currentRevenueTrendByOta;
    }

    public Map<String, Integer> getCurrentRoomSoldTrendByOta() {
        if (this.currentRoomSoldTrendByOta ==null){
            this.currentRoomSoldTrendByOta = new LinkedHashMap<>();
        }
        return currentRoomSoldTrendByOta;
    }

    public void setCurrentRoomSoldTrendByOta(Map<String, Integer> currentRoomSoldTrendByOta) {
        this.currentRoomSoldTrendByOta = currentRoomSoldTrendByOta;
    }

    public Map<String, Double> getLastYearCurrentRevenueTrendByOta() {
        if (this.lastYearCurrentRevenueTrendByOta ==null){
            this.lastYearCurrentRevenueTrendByOta = new LinkedHashMap<>();
        }
        return lastYearCurrentRevenueTrendByOta;
    }

    public void setLastYearCurrentRevenueTrendByOta(Map<String, Double> lastYearCurrentRevenueTrendByOta) {
        this.lastYearCurrentRevenueTrendByOta = lastYearCurrentRevenueTrendByOta;
    }

    public Map<String, Integer> getLastYearCurrentRoomSoldTrendByOta() {
        if (this.lastYearCurrentRoomSoldTrendByOta ==null){
            this.lastYearCurrentRoomSoldTrendByOta = new LinkedHashMap<>();
        }
        return lastYearCurrentRoomSoldTrendByOta;
    }

    public void setLastYearCurrentRoomSoldTrendByOta(Map<String, Integer> lastYearCurrentRoomSoldTrendByOta) {
        this.lastYearCurrentRoomSoldTrendByOta = lastYearCurrentRoomSoldTrendByOta;
    }

	public Map<String, Double> getCurrentAdrTrend() {
		if (this.currentAdrTrend ==null){
            this.currentAdrTrend = new LinkedHashMap<>();
        }
		return currentAdrTrend;
	}

	public void setCurrentAdrTrend(Map<String, Double> currentAdrTrend) {
		this.currentAdrTrend = currentAdrTrend;
	}

	public Map<String, Double> getLastYearAdrTrend() {
		if (this.lastYearAdrTrend ==null){
            this.lastYearAdrTrend = new LinkedHashMap<>();
        }
		return lastYearAdrTrend;
	}

	public void setLastYearAdrTrend(Map<String, Double> lastYearAdrTrend) {
		this.lastYearAdrTrend = lastYearAdrTrend;
	}

	public Map<String, Double> getCurrentAdrTrendByOta() {
		if (this.currentAdrTrendByOta ==null){
            this.currentAdrTrendByOta = new LinkedHashMap<>();
        }
		return currentAdrTrendByOta;
	}

	public void setCurrentAdrTrendByOta(Map<String, Double> currentAdrTrendByOta) {
		this.currentAdrTrendByOta = currentAdrTrendByOta;
	}

	public Map<String, Double> getLastYearAdrTrendByOta() {
		if (this.lastYearAdrTrendByOta ==null){
            this.lastYearAdrTrendByOta = new LinkedHashMap<>();
        }
		return lastYearAdrTrendByOta;
	}

	public void setLastYearAdrTrendByOta(Map<String, Double> lastYearAdrTrendByOta) {
		this.lastYearAdrTrendByOta = lastYearAdrTrendByOta;
	}

	public Map<String, Integer> getAvailableCapacity() {
		if (this.availableCapacity ==null){
            this.availableCapacity = new LinkedHashMap<>();
        }
		return availableCapacity;
	}

	public void setAvailableCapacity(Map<String, Integer> availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public Map<String, Double> getSameTimelastYearCurrentRevenueTrend() {
		if (this.sameTimelastYearCurrentRevenueTrend ==null){
            this.sameTimelastYearCurrentRevenueTrend = new LinkedHashMap<>();
        }
		return sameTimelastYearCurrentRevenueTrend;
	}

	public void setSameTimelastYearCurrentRevenueTrend(Map<String, Double> sameTimelastYearCurrentRevenueTrend) {
		this.sameTimelastYearCurrentRevenueTrend = sameTimelastYearCurrentRevenueTrend;
	}

	public Map<String, Integer> getSameTimelastYearCurrentRoomSoldTrend() {
		if (this.sameTimelastYearCurrentRoomSoldTrend ==null){
            this.sameTimelastYearCurrentRoomSoldTrend = new LinkedHashMap<>();
        }
		return sameTimelastYearCurrentRoomSoldTrend;
	}

	public void setSameTimelastYearCurrentRoomSoldTrend(Map<String, Integer> sameTimelastYearCurrentRoomSoldTrend) {
		this.sameTimelastYearCurrentRoomSoldTrend = sameTimelastYearCurrentRoomSoldTrend;
	}

	public Map<String, Double> getSameTimelastYearAdrTrend() {
		if (this.sameTimelastYearAdrTrend ==null){
            this.sameTimelastYearAdrTrend = new LinkedHashMap<>();
        }
		return sameTimelastYearAdrTrend;
	}

	public void setSameTimelastYearAdrTrend(Map<String, Double> sameTimelastYearAdrTrend) {
		this.sameTimelastYearAdrTrend = sameTimelastYearAdrTrend;
	}

	public Map<String, Double> getSameTimelastYearCurrentRevenueTrendByOta() {
		if (this.sameTimelastYearCurrentRevenueTrendByOta ==null){
            this.sameTimelastYearCurrentRevenueTrendByOta = new LinkedHashMap<>();
        }
		return sameTimelastYearCurrentRevenueTrendByOta;
	}

	public void setSameTimelastYearCurrentRevenueTrendByOta(Map<String, Double> sameTimelastYearCurrentRevenueTrendByOta) {
		this.sameTimelastYearCurrentRevenueTrendByOta = sameTimelastYearCurrentRevenueTrendByOta;
	}

	public Map<String, Integer> getSameTimelastYearCurrentRoomSoldTrendByOta() {
		if (this.sameTimelastYearCurrentRoomSoldTrendByOta ==null){
            this.sameTimelastYearCurrentRoomSoldTrendByOta = new LinkedHashMap<>();
        }
		return sameTimelastYearCurrentRoomSoldTrendByOta;
	}

	public void setSameTimelastYearCurrentRoomSoldTrendByOta(
			Map<String, Integer> sameTimelastYearCurrentRoomSoldTrendByOta) {
		this.sameTimelastYearCurrentRoomSoldTrendByOta = sameTimelastYearCurrentRoomSoldTrendByOta;
	}

	public Map<String, Double> getSameTimelastYearAdrTrendByOta() {
		if (this.sameTimelastYearAdrTrendByOta ==null){
            this.sameTimelastYearAdrTrendByOta = new LinkedHashMap<>();
        }
		return sameTimelastYearAdrTrendByOta;
	}

	public void setSameTimelastYearAdrTrendByOta(Map<String, Double> sameTimelastYearAdrTrendByOta) {
		this.sameTimelastYearAdrTrendByOta = sameTimelastYearAdrTrendByOta;
	}

	public Map<String, Double> getLastMonthADRPickup() {
		if (this.lastMonthADRPickup ==null){
            this.lastMonthADRPickup = new LinkedHashMap<>();
        }
		return lastMonthADRPickup;
	}

	public void setLastMonthADRPickup(Map<String, Double> lastMonthADRPickup) {
		this.lastMonthADRPickup = lastMonthADRPickup;
	}

	public Map<String, Double> getCurrentYearRates() {
		if (this.currentYearRates ==null){
            this.currentYearRates = new LinkedHashMap<>();
        }
		return currentYearRates;
	}

	public void setCurrentYearRates(Map<String, Double> currentYearRates) {
		this.currentYearRates = currentYearRates;
	}
    
	
	
}

package com.revnomix.revseed.wrapper.analysis;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;

public class AnalysisOtaPerformanceDto {
    SimpleDateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy") ;

    private String subtitleThisYear;
    private String subtitleLastYear;
    private String subtitleSTLYear;

    private AnalysisOtaData thisYearRoomNightsOtaVsAllOta;
    private AnalysisOtaData lastYearRoomNightsOtaVsAllOta;
    private AnalysisOtaData stlYearRoomNightsOtaVsAllOta;

    private AnalysisOtaData thisYearRevenueOtaVsAllOta;
    private AnalysisOtaData lastYearRevenueOtaVsAllOta;
    private AnalysisOtaData stlYearRevenueOtaVsAllOta;

    private Map<String,Double> thisYearRevenueOta;
    private Map<String,Double>  lastYearRevenueOta;
    private Map<String,Double>  stlYearRevenueOta;

    private Map<String,Integer>  thisYearRoomNightsOta;
    private Map<String,Integer>  lastYearRoomNightsOta;
    private Map<String,Integer>  stlYearRoomNightsOta;
    
    private ArrayList<String> pickupDateList;
    private Map<String, List<Integer>> pickupDataList;
    private Map<String, List<Double>> pickupRevenueList;
    private Map<String, List<Double>> pickupADRList;

    public void setSubtitle(DateTime startDate, DateTime endDate) {
        this.subtitleThisYear = pattern.format(startDate.toDate()) +" to " +pattern.format(endDate.toDate());
        this.subtitleLastYear = pattern.format(startDate.minusYears(1).toDate()) +" to " +pattern.format(endDate.minusYears(1).toDate());
    }

    public String getSubtitleThisYear() {
        return subtitleThisYear;
    }

    public void setSubtitleThisYear(String subtitleThisYear) {
        this.subtitleThisYear = subtitleThisYear;
    }

    public String getSubtitleLastYear() {
        return subtitleLastYear;
    }

    public void setSubtitleLastYear(String subtitleLastYear) {
        this.subtitleLastYear = subtitleLastYear;
    }

    public AnalysisOtaData getThisYearRoomNightsOtaVsAllOta() {
        return thisYearRoomNightsOtaVsAllOta;
    }

    public void setThisYearRoomNightsOtaVsAllOta(AnalysisOtaData thisYearRoomNightsOtaVsAllOta) {
        this.thisYearRoomNightsOtaVsAllOta = thisYearRoomNightsOtaVsAllOta;
    }

    public AnalysisOtaData getLastYearRoomNightsOtaVsAllOta() {
        return lastYearRoomNightsOtaVsAllOta;
    }

    public void setLastYearRoomNightsOtaVsAllOta(AnalysisOtaData lastYearRoomNightsOtaVsAllOta) {
        this.lastYearRoomNightsOtaVsAllOta = lastYearRoomNightsOtaVsAllOta;
    }

    public AnalysisOtaData getThisYearRevenueOtaVsAllOta() {
        return thisYearRevenueOtaVsAllOta;
    }

    public void setThisYearRevenueOtaVsAllOta(AnalysisOtaData thisYearRevenueOtaVsAllOta) {
        this.thisYearRevenueOtaVsAllOta = thisYearRevenueOtaVsAllOta;
    }

    public AnalysisOtaData getLastYearRevenueOtaVsAllOta() {
        return lastYearRevenueOtaVsAllOta;
    }

    public void setLastYearRevenueOtaVsAllOta(AnalysisOtaData lastYearRevenueOtaVsAllOta) {
        this.lastYearRevenueOtaVsAllOta = lastYearRevenueOtaVsAllOta;
    }

    public Map<String, Double> getThisYearRevenueOta() {
        if (thisYearRevenueOta == null){
            thisYearRevenueOta=new HashMap<>();
        }
        return thisYearRevenueOta;
    }

    public void setThisYearRevenueOta(Map<String, Double> thisYearRevenueOta) {
        this.thisYearRevenueOta = thisYearRevenueOta;
    }

    public Map<String, Double> getLastYearRevenueOta() {
        if (lastYearRevenueOta == null){
            lastYearRevenueOta=new HashMap<>();
        }
        return lastYearRevenueOta;
    }

    public void setLastYearRevenueOta(Map<String, Double> lastYearRevenueOta) {
        this.lastYearRevenueOta = lastYearRevenueOta;
    }

    public Map<String, Integer> getThisYearRoomNightsOta() {
        if (thisYearRoomNightsOta == null){
            thisYearRoomNightsOta=new HashMap<>();
        }
        return thisYearRoomNightsOta;
    }

    public void setThisYearRoomNightsOta(Map<String, Integer> thisYearRoomNightsOta) {
        this.thisYearRoomNightsOta = thisYearRoomNightsOta;
    }

    public Map<String, Integer> getLastYearRoomNightsOta() {
        if (lastYearRoomNightsOta == null){
            lastYearRoomNightsOta=new HashMap<>();
        }
        return lastYearRoomNightsOta;
    }

    public void setLastYearRoomNightsOta(Map<String, Integer> lastYearRoomNightsOta) {
        this.lastYearRoomNightsOta = lastYearRoomNightsOta;
    }

	public String getSubtitleSTLYear() {
		return subtitleSTLYear;
	}

	public void setSubtitleSTLYear(String subtitleSTLYear) {
		this.subtitleSTLYear = subtitleSTLYear;
	}

	public AnalysisOtaData getStlYearRoomNightsOtaVsAllOta() {
		return stlYearRoomNightsOtaVsAllOta;
	}

	public void setStlYearRoomNightsOtaVsAllOta(AnalysisOtaData stlYearRoomNightsOtaVsAllOta) {
		this.stlYearRoomNightsOtaVsAllOta = stlYearRoomNightsOtaVsAllOta;
	}

	public AnalysisOtaData getStlYearRevenueOtaVsAllOta() {
		return stlYearRevenueOtaVsAllOta;
	}

	public void setStlYearRevenueOtaVsAllOta(AnalysisOtaData stlYearRevenueOtaVsAllOta) {
		this.stlYearRevenueOtaVsAllOta = stlYearRevenueOtaVsAllOta;
	}

	public Map<String, Double> getStlYearRevenueOta() {
		return stlYearRevenueOta;
	}

	public void setStlYearRevenueOta(Map<String, Double> stlYearRevenueOta) {
		this.stlYearRevenueOta = stlYearRevenueOta;
	}

	public Map<String, Integer> getStlYearRoomNightsOta() {
		return stlYearRoomNightsOta;
	}

	public void setStlYearRoomNightsOta(Map<String, Integer> stlYearRoomNightsOta) {
		this.stlYearRoomNightsOta = stlYearRoomNightsOta;
	}

	public ArrayList<String> getPickupDateList() {
		return pickupDateList;
	}

	public void setPickupDateList(ArrayList<String> pickupDateList) {
		this.pickupDateList = pickupDateList;
	}

	public Map<String, List<Integer>> getPickupDataList() {
		return pickupDataList;
	}

	public void setPickupDataList(Map<String, List<Integer>> pickupDataList) {
		this.pickupDataList = pickupDataList;
	}

	public Map<String, List<Double>> getPickupRevenueList() {
		return pickupRevenueList;
	}

	public void setPickupRevenueList(Map<String, List<Double>> pickupRevenueList) {
		this.pickupRevenueList = pickupRevenueList;
	}

	public Map<String, List<Double>> getPickupADRList() {
		return pickupADRList;
	}

	public void setPickupADRList(Map<String, List<Double>> pickupADRList) {
		this.pickupADRList = pickupADRList;
	}
    
    
}

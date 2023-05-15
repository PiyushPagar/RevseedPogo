package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.RateHorizon;

import java.io.Serializable;
import java.util.Date;

public class RateHorizonDto implements Serializable {
	
    public Date date;
    public Date horizonDate;
    public Integer clientId;
    public Date endDateRange;
    public Date startDateRange;
    public Integer startPacePoint;
    public Integer pacePoint;
    public Integer endPacePoint;
    public String algo;
    
    public RateHorizonDto(Date date, RateHorizon rateHorizons1){

    }

    public RateHorizonDto(){

    }
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public Date getEndDateRange() {
        return endDateRange;
    }

    public void setEndDateRange(Date endDateRange) {
        this.endDateRange = endDateRange;
    }

    public Date getStartDateRange() {
        return startDateRange;
    }

    public void setStartDateRange(Date startDateRange) {
        this.startDateRange = startDateRange;
    }

    public Integer getStartPacePoint() {
        return startPacePoint;
    }

    public void setStartPacePoint(Integer startPacePoint) {
        this.startPacePoint = startPacePoint;
    }

    public Integer getEndPacePoint() {
        return endPacePoint;
    }

    public void setEndPacePoint(Integer endPacePoint) {
        this.endPacePoint = endPacePoint;
    }

	public Date getHorizonDate() {
		return horizonDate;
	}

	public void setHorizonDate(Date horizonDate) {
		this.horizonDate = horizonDate;
	}

	public Integer getPacePoint() {
		return pacePoint;
	}

	public void setPacePoint(Integer pacePoint) {
		this.pacePoint = pacePoint;
	}
	
	

}

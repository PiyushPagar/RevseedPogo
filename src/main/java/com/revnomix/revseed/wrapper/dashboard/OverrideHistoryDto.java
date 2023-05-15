package com.revnomix.revseed.wrapper.dashboard;

import java.util.Date;

public class OverrideHistoryDto {

	private String overriddenDate;
	private String type;
	private String strategy;
	private String value;
	private String overriddenBy;
	private Date occupancyDate;
	private Integer clientId;
	private String status;
	private String remarkCode;
	private String remark;
	
	
	public String getOverriddenDate() {
		return overriddenDate;
	}
	public void setOverriddenDate(String overriddenDate) {
		this.overriddenDate = overriddenDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOverriddenBy() {
		return overriddenBy;
	}
	public void setOverriddenBy(String overriddenBy) {
		this.overriddenBy = overriddenBy;
	}
	public Date getOccupancyDate() {
		return occupancyDate;
	}
	public void setOccupancyDate(Date occupancyDate) {
		this.occupancyDate = occupancyDate;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "OverrideHistoryDto [overriddenDate=" + overriddenDate + ", type=" + type + ", strategy=" + strategy
				+ ", value=" + value + ", overriddenBy=" + overriddenBy + ", occupancyDate=" + occupancyDate
				+ ", clientId=" + clientId + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarkCode() {
		return remarkCode;
	}
	public void setRemarkCode(String remarkCode) {
		this.remarkCode = remarkCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

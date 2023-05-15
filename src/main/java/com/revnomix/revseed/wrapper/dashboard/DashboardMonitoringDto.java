package com.revnomix.revseed.wrapper.dashboard;

//Vinav
public class DashboardMonitoringDto {

    private String id;
    private String propertyName;
    private String hotelID;
    private String rmCode;
    private String location;
    private String accountManager;
    private String channelManager;
    private String capacity;
    private String status;
    private Boolean ratePush;
    private String runCalibration;
    private String runRecommendation;
    private String bookingsSynchedon;
    private String inventorySyncedon;
    private String rateSyncedon;
    private String hnfUploadedon;
    private String ratesShopedon;
    private String calibrationRunon;
    private String recommendationRunon;
    private String bookingDataAvailablefrom;
    private String bookingDataAvailableto;
    private String inventoryAvailability;
    private String rateAvailability;
    private String rateShopAvailability;
    private Integer grossPickup;
    private Integer netPickup;
    private Integer arrivals;
    private Integer departures;
    private Integer next30days;
    private Integer next60days;
    private Integer next90days;
    private Integer next365days;
    
    public DashboardMonitoringDto() {}
    
	public DashboardMonitoringDto(String id, String propertyName, String hotelID, String rmCode, String location,
			String accountManager,String channelManager, String capacity, String status, Boolean ratePush, String runCalibration,
			String runRecommendation, String bookingsSynchedon, String inventorySyncedon, String rateSyncedon,
			String hnfUploadedon, String ratesShopedon, String calibrationRunon, String recommendationRunon,
			String bookingDataAvailablefrom, String bookingDataAvailableto, String inventoryAvailability,
			String rateAvailability, String rateShopAvailability, Integer grossPickup, Integer netPickup, Integer arrivals,
			Integer departures, Integer next30days, Integer next60days, Integer next90days, Integer next365days) {
		super();
		this.id = id;
		this.propertyName = propertyName;
		this.hotelID = hotelID;
		this.rmCode = rmCode;
		this.location = location;
		this.accountManager = accountManager;
		this.channelManager = channelManager;
		this.capacity = capacity;
		this.status = status;
		this.ratePush = ratePush;
		this.runCalibration = runCalibration;
		this.runRecommendation = runRecommendation;
		this.bookingsSynchedon = bookingsSynchedon;
		this.inventorySyncedon = inventorySyncedon;
		this.rateSyncedon = rateSyncedon;
		this.hnfUploadedon = hnfUploadedon;
		this.ratesShopedon = ratesShopedon;
		this.calibrationRunon = calibrationRunon;
		this.recommendationRunon = recommendationRunon;
		this.bookingDataAvailablefrom = bookingDataAvailablefrom;
		this.bookingDataAvailableto = bookingDataAvailableto;
		this.inventoryAvailability = inventoryAvailability;
		this.rateAvailability = rateAvailability;
		this.rateShopAvailability = rateShopAvailability;
		this.grossPickup = grossPickup;
		this.netPickup = netPickup;
		this.arrivals = arrivals;
		this.departures = departures;
		this.next30days = next30days;
		this.next60days = next60days;
		this.next90days = next90days;
		this.next365days = next365days;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getRatePush() {
		return ratePush;
	}

	public void setRatePush(boolean ratePush) {
		this.ratePush = ratePush;
	}

	public String getRunCalibration() {
		return runCalibration;
	}

	public void setRunCalibration(String runCalibration) {
		this.runCalibration = runCalibration;
	}

	public String getRunRecommendation() {
		return runRecommendation;
	}

	public void setRunRecommendation(String runRecommendation) {
		this.runRecommendation = runRecommendation;
	}

	public String getBookingsSynchedon() {
		return bookingsSynchedon;
	}

	public void setBookingsSynchedon(String bookingsSynchedon) {
		this.bookingsSynchedon = bookingsSynchedon;
	}

	public String getInventorySyncedon() {
		return inventorySyncedon;
	}

	public void setInventorySyncedon(String inventorySyncedon) {
		this.inventorySyncedon = inventorySyncedon;
	}

	public String getRateSyncedon() {
		return rateSyncedon;
	}

	public void setRateSyncedon(String rateSyncedon) {
		this.rateSyncedon = rateSyncedon;
	}

	public String getHnfUploadedon() {
		return hnfUploadedon;
	}

	public void setHnfUploadedon(String hnfUploadedon) {
		this.hnfUploadedon = hnfUploadedon;
	}

	public String getRatesShopedon() {
		return ratesShopedon;
	}

	public void setRatesShopedon(String ratesShopedon) {
		this.ratesShopedon = ratesShopedon;
	}

	public String getCalibrationRunon() {
		return calibrationRunon;
	}

	public void setCalibrationRunon(String calibrationRunon) {
		this.calibrationRunon = calibrationRunon;
	}

	public String getRecommendationRunon() {
		return recommendationRunon;
	}

	public void setRecommendationRunon(String recommendationRunon) {
		this.recommendationRunon = recommendationRunon;
	}

	public String getBookingDataAvailablefrom() {
		return bookingDataAvailablefrom;
	}

	public void setBookingDataAvailablefrom(String bookingDataAvailablefrom) {
		this.bookingDataAvailablefrom = bookingDataAvailablefrom;
	}

	public String getBookingDataAvailableto() {
		return bookingDataAvailableto;
	}

	public void setBookingDataAvailableto(String bookingDataAvailableto) {
		this.bookingDataAvailableto = bookingDataAvailableto;
	}

	public String getInventoryAvailability() {
		return inventoryAvailability;
	}

	public void setInventoryAvailability(String inventoryAvailability) {
		this.inventoryAvailability = inventoryAvailability;
	}

	public String getRateAvailability() {
		return rateAvailability;
	}

	public void setRateAvailability(String rateAvailability) {
		this.rateAvailability = rateAvailability;
	}

	public String getRateShopAvailability() {
		return rateShopAvailability;
	}

	public void setRateShopAvailability(String rateShopAvailability) {
		this.rateShopAvailability = rateShopAvailability;
	}

	public Integer getGrossPickup() {
		return grossPickup;
	}

	public void setGrossPickup(Integer grossPickup) {
		this.grossPickup = grossPickup;
	}

	public Integer getNetPickup() {
		return netPickup;
	}

	public void setNetPickup(Integer netPickup) {
		this.netPickup = netPickup;
	}

	public Integer getArrivals() {
		return arrivals;
	}

	public void setArrivals(Integer arrivals) {
		this.arrivals = arrivals;
	}

	public Integer getDepartures() {
		return departures;
	}

	public void setDepartures(Integer departures) {
		this.departures = departures;
	}

	public Integer getNext30days() {
		return next30days;
	}

	public void setNext30days(Integer next30days) {
		this.next30days = next30days;
	}

	public Integer getNext60days() {
		return next60days;
	}

	public void setNext60days(Integer next60days) {
		this.next60days = next60days;
	}

	public Integer getNext90days() {
		return next90days;
	}

	public void setNext90days(Integer next90days) {
		this.next90days = next90days;
	}

	public Integer getNext365days() {
		return next365days;
	}

	public void setNext365days(Integer next365days) {
		this.next365days = next365days;
	}
	
	

	public String getChannelManager() {
		return channelManager;
	}

	public void setChannelManager(String channelManager) {
		this.channelManager = channelManager;
	}

	public void setRatePush(Boolean ratePush) {
		this.ratePush = ratePush;
	}

	@Override
	public String toString() {
		return "DashboardMonitoringDto [id=" + id + ", propertyName=" + propertyName + ", hotelID=" + hotelID
				+ ", rmCode=" + rmCode + ", location=" + location + ", accountManager=" + accountManager + ", capacity="
				+ capacity + ", status=" + status + ", ratePush=" + ratePush + ", runCalibration=" + runCalibration
				+ ", runRecommendation=" + runRecommendation + ", bookingsSynchedon=" + bookingsSynchedon
				+ ", inventorySyncedon=" + inventorySyncedon + ", rateSyncedon=" + rateSyncedon + ", hnfUploadedon="
				+ hnfUploadedon + ", ratesShopedon=" + ratesShopedon + ", calibrationRunon=" + calibrationRunon
				+ ", recommendationRunon=" + recommendationRunon + ", bookingDataAvailablefrom="
				+ bookingDataAvailablefrom + ", bookingDataAvailableto=" + bookingDataAvailableto
				+ ", inventoryAvailability=" + inventoryAvailability + ", rateAvailability=" + rateAvailability
				+ ", rateShopAvailability=" + rateShopAvailability + ", grossPickup=" + grossPickup + ", netPickup="
				+ netPickup + ", arrivals=" + arrivals + ", departures=" + departures + ", next30days=" + next30days
				+ ", next60days=" + next60days + ", next90days=" + next90days + ", next365days=" + next365days + "]";
	}
    
    

}

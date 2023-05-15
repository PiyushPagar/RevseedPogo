package com.revnomix.revseed.wrapper;

import java.util.Date;

public class ISellDto {

    private Date occupancyDate;
    private EventDto eventDto;
    private OtaPerformanceDto otaPerformanceDto;
    private CompetitorPricingDto competitorPricingDto;
    private RateDto rateDto;

    public Date getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(Date occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public EventDto getEventDto() {
        return eventDto;
    }

    public void setEventDto(EventDto eventDto) {
        this.eventDto = eventDto;
    }

    public OtaPerformanceDto getOtaPerformanceDto() {
        return otaPerformanceDto;
    }

    public void setOtaPerformanceDto(OtaPerformanceDto otaPerformanceDto) {
        this.otaPerformanceDto = otaPerformanceDto;
    }

    public CompetitorPricingDto getCompetitorPricingDto() {
        return competitorPricingDto;
    }

    public void setCompetitorPricingDto(CompetitorPricingDto competitorPricingDto) {
        this.competitorPricingDto = competitorPricingDto;
    }

    public RateDto getRateDto() {
        return rateDto;
    }

    public void setRateDto(RateDto rateDto) {
        this.rateDto = rateDto;
    }
}

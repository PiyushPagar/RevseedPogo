package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.HistoryAndForecast;
import com.revnomix.revseed.wrapper.PerformanceDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HistoryAndForecastRepository extends JpaRepository<HistoryAndForecast,Integer> {
    List<HistoryAndForecast> findByClientId(String clientId);

    Optional<List<HistoryAndForecast>> findAllByClientId(Integer clientId);
    Optional<List<HistoryAndForecast>> findAllByClientIdAndDateBetween(Integer clientId, Date fromDate, Date toDate);

    @Query(nativeQuery = true, value = "select * from history_and_forecast hf where hf.client_id= :clientId and date(hf.updated_date) = :updatedDate ")
    Optional<List<HistoryAndForecast>> findAllByClientIdAndUpdatedDate(Integer clientId, Date updatedDate);

    boolean existsByUpdatedDate (java.sql.Date date);
    Optional<List<HistoryAndForecast>> findAllByClientIdAndDate(Integer clientId, Date date);

    Optional<HistoryAndForecast> findByClientIdAndDateAndAvailabilityAndCapacityAndRevenueAndRoomsSoldAndHotelId(Integer clientId, Date date, Integer availability, Integer capacity, BigDecimal revenue, Integer roomsSold, Integer hotelId);
    List<HistoryAndForecast> findByHotelId(Integer hotelId);
    
    @Query(nativeQuery = true, name = "HistoryAndForecast.findHnFRevenueAndRoomAndClientByDate")
    List<PerformanceDto> findHnFRevenueAndRoomAndClientByDate(Integer clientId, Date fromDate, Date toDate);

}

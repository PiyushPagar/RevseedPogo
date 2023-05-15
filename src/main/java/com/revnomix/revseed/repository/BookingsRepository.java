package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Bookings;
import com.revnomix.revseed.wrapper.BookingsDto;
import com.revnomix.revseed.wrapper.OtaDowSumDto;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;
import com.revnomix.revseed.wrapper.dashboard.PickupTrendDto;
import com.revnomix.revseed.wrapper.dashboard.PickupValueDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings,Integer> {
    List<Bookings> findByOtaId(Integer otaId);
    List<Bookings> findAllByClientId(Integer clientId);
    List<Bookings> findAllByBookingNo(String bookingNo);
    List<Bookings> findAllByBookingNoAndClientId(String bookingNo ,Integer clientId);
    List<Bookings> findAllByBookingNoAndCmStatusInAndClientId(String bookingNo , List<String> status,Integer clientId);
    List<Bookings> findAllByCmStatusIn(List<String> status);
    List<Bookings> findAllByChannelRef(String channelRef);
    List<Bookings> findAllByChannelRefAndChannelManager(String channelRef,String channelManager);
    @Query(nativeQuery = true)
    List<PickupTrendDto> findRevenuePickup(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<Double> findLOS(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<Double> findLOSforOTA(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("otas")List<String> otas);

    @Query(nativeQuery = true)
    OtaDowSumDto findSumByOta(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("otasId") Integer otasId);

    @Query(nativeQuery = true)
    OtaDowSumDto findSumByDow(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<Double> findSumByDayToArrival(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<Double> findSumByDayToArrivalforOTA(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("otas")List<String>otas);

    Bookings findByBookingNoAndClientId(String bookingId, Integer clientId);

    long countByBookingNoAndClientId(String bookingId, Integer clientId);

    @Transactional
    void deleteByBookingNo(String bookingNo);

    @Query(nativeQuery = true)
    PickupValueDto findNewPickupForDuration(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    @Query(nativeQuery = true)
    PickupValueDto findCancelPickupForDuration(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("status") List<String> status);

    @Query(nativeQuery = true)
    PickupValueDto findPickupDuration(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate,  @Param("status") List<String> status);
    
    @Query(nativeQuery = true)
    PickupValueDto findPickupDurationByOta(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("otaId") Integer otaId);

    @Query(nativeQuery = true)
    PickupValueDto findGrossPickupDuration(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
      
    @Query(nativeQuery = true)
    BookingsDto findBookingDetails(@Param("clientId") Integer clientId);

    @Query(nativeQuery = true, value = "SELECT max(regdate) FROM staah_inventory where client_id = :clientId ")
    Date findByClientIdInventory(Integer clientId);
    
    @Query(nativeQuery = true, value = "SELECT regdate FROM staah_inventory where client_id = :clientId GROUP BY regdate ORDER BY regdate DESC LIMIT 1")
    List<Date> findByClientIdInventoryList(Integer clientId);

    @Query(nativeQuery = true, value = "SELECT max(regdate) FROM staah_rates where client_id = :clientId ")
    Date findByClientIdRate(Integer clientId);
    
    @Query(nativeQuery = true, value = "SELECT regdate FROM staah_rates where client_id = :clientId GROUP BY regdate ORDER BY regdate DESC LIMIT 1")
    List<Date> findByClientIdRateList(Integer clientId);

    @Query(nativeQuery = true, value = "SELECT max(updated_date) FROM history_and_forecast where client_id = :clientId ")
    Date findByClientIdHnf(Integer clientId);
    
    @Query(nativeQuery = true, value = "SELECT updated_date FROM history_and_forecast where client_id = :clientId GROUP BY updated_date ORDER BY updated_date DESC LIMIT 1")
    List<Date> findByClientIdHnfList(Integer clientId);

    @Query(nativeQuery = true, value = "select max(date_collected) from rm_rates where hotel_code = (SELECT rm_code FROM hotels where id = (select hotel_id from clients where id = :clientId)) ")
    Date findByClientIdRateShopDate(Integer clientId);

    @Query(nativeQuery = true, value = "select date_collected from rm_rates where hotel_code = :rmCode GROUP BY date_collected ORDER BY date_collected DESC LIMIT 1")
    List<Date> findByClientIdRateShopDateList(Integer rmCode);
    
    @Query(nativeQuery = true, value = "select max(checkout_date) from rm_rates where hotel_code = (SELECT rm_code FROM hotels where id = (select hotel_id from clients where id = :clientId)) ")
    Date findByClientIdRateShopAvailable(Integer clientId);

    @Query(nativeQuery = true, value = "SELECT booking_no FROM bookings GROUP BY booking_no HAVING COUNT(booking_no) > 2; ")
    List<String> findAllBookingNo();

    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomByDateQuery")
    List<Integer> findRevenueAndRoomByDate(Integer clientId, Date startDate);
    
    @Query(nativeQuery = true, value = "SELECT * FROM bookings WHERE client_id = :clientId AND regdate >= :fromDate")
    List<Bookings> findAllByClientIdAndRegDate(Integer clientId, Date fromDate);
    
    @Query(nativeQuery = true, value = "SELECT * FROM bookings bk join booking_pace_occupancy_by_date bpobd on bpobd.booking_id = bk.id WHERE bpobd.client_id = :clientId AND occupancy_date >= '2021-04-01'  AND  occupancy_date <= '2021-04-30'")
    List<Bookings> findAllByMatchingBookingAndBookingPace (Integer clientId);
    
    @Query(nativeQuery = true)
	Integer findGraphRoomPickup(Integer clientId, Date startDate, Date endDate);
	
    @Query(nativeQuery = true)
	Double findGraphRevenuePickup(Integer clientId, Date startDate, Date endDate);
    
	List<Bookings> findByHotelId(Integer id);
	
	@Query(nativeQuery = true)
	Integer findGraphRoomPickupOTA(Integer clientId, Date startDate, Date endDate, List<String> otaList);
	
	@Query(nativeQuery = true)
	Double findGraphRevenuePickupOTA(Integer clientId, Date startDate, Date endDate, List<String> otaList);
	
	@Query(nativeQuery = true)
	List<PickupTrendDto> findRevenuePickupOTA(Integer clientId, Date startDate, Date endDate, List<String> otaList);
}

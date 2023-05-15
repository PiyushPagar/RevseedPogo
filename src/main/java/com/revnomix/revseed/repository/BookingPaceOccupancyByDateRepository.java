package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.BookingPaceOccupancyByDate;
import com.revnomix.revseed.wrapper.OccupancyByDateDto;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;
import com.revnomix.revseed.wrapper.PerformanceDto;
import com.revnomix.revseed.wrapper.RPDADRDto;
import com.revnomix.revseed.wrapper.analysis.AdrByDOW;
import com.revnomix.revseed.wrapper.analysis.PercentileDto;
import com.revnomix.revseed.wrapper.analysis.SoldDto;
import com.revnomix.revseed.wrapper.analysis.TrendByOtaDtoAndDate;
import com.revnomix.revseed.wrapper.dashboard.PickupDto;
import com.revnomix.revseed.wrapper.dashboard.PickupTrendDto;
import com.revnomix.revseed.wrapper.dashboard.TrendByOtaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingPaceOccupancyByDateRepository extends JpaRepository<BookingPaceOccupancyByDate, Integer> {
    BookingPaceOccupancyByDate findByBookingIdAndOccupancyDate(Integer id, Date occupancyDate);
    List<BookingPaceOccupancyByDate> findByBookingId(Integer id);
    @Query(nativeQuery = true)
    SoldDto findCountOfBookingInGivenAdrRangeAndOccupancyDate(Integer clientId, Date startDate, Date endDate, Integer lowAdr, Integer highAdr);
    @Query(nativeQuery = true)
    SoldDto findCountOfBookingGtrThanGivenAdrAndOccupancyDate(Integer clientId,Date startDate,Date endDate,Integer lowAdr);
    @Query(nativeQuery = true)
    SoldDto findCountOfBookingLessThanGivenAdrAndOccupancyDate(Integer clientId,Date startDate,Date endDate,Integer lowAdr);

    @Query(nativeQuery = true)
    SoldDto findCountOfBookingInGivenAdrRangeAndOccupancyDateAndOtas(Integer clientId, Date startDate, Date endDate, Integer lowAdr, Integer highAdr, List<String> otas);
    @Query(nativeQuery = true)
    SoldDto findCountOfBookingGtrThanGivenAdrAndOccupancyDateAndOtas(Integer clientId, Date startDate, Date endDate, Integer lowAdr, List<String> otas);
    @Query(nativeQuery = true)
    SoldDto findCountOfBookingLessThanGivenAdrAndOccupancyDateAndOtas(Integer clientId, Date startDate, Date endDate, Integer lowAdr, List<String> otas);
    @Query(nativeQuery = true)
    List<AdrByDOW> getMinMaxByDOW(Integer clientId,Date startDate, Date endDate);
    @Query(nativeQuery = true)
    List<AdrByDOW> getMinMaxByDOWAndOtas(Integer clientId,Date startDate, Date endDate, List<String> otas);

    List<SoldDto> findSumByDayToArrivalforOTA(Integer clientId,Date startDate, Date endDate, List<String> otas);

    List<SoldDto> findSumByDayToArrival(Integer clientId,Date startDate, Date endDate);
    @Query(nativeQuery = true)
    List<OtaPerformanceDto> findAllOtaPerformanceByClientIdAndOccupancyDate(Integer clientId, Date startDate, Date endDate);
   
    
    @Query(nativeQuery = true)
    List<TrendByOtaDto> findTrendByOta(@Param("clientId") Integer clientId,
                                       @Param("startDate") Date startDate,
                                       @Param("endDate") Date endDate);
    
    @Query(nativeQuery = true)
    List<TrendByOtaDto> findPerformanceTrendByOta(@Param("clientId") Integer clientId,
                                       @Param("startDate") Date startDate,
                                       @Param("endDate") Date endDate);
    
    @Query(nativeQuery = true)
    List<TrendByOtaDto> findSTLYPerformanceTrendByOta(@Param("clientId") Integer clientId,
                                       @Param("startDate") Date startDate,
                                       @Param("endDate") Date endDate,
                                       @Param("monthDate") Date monthDate);
    
    @Query(nativeQuery = true)
    List<TrendByOtaDtoAndDate> findTrendByOtaAndDate(@Param("clientId") Integer clientId,
                                                     @Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate);
    @Query(nativeQuery = true)
    List<TrendByOtaDtoAndDate> findByOtaAndDate(@Param("clientId") Integer clientId,
                                                     @Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate);
    @Query(nativeQuery = true)
    List<Integer> findTotalArrivals(@Param("clientId") Integer clientId,
                                    @Param("startDate") Date startDate,
                                    @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<Integer> findTotalArrivalsForOTA(@Param("clientId") Integer clientId,
                                          @Param("startDate") Date startDate,
                                          @Param("endDate") Date endDate, @Param("otas") List<String> otas);

    @Query(nativeQuery = true)
    OtaPerformanceDto getSumOfOtaPerformance(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    OtaPerformanceDto getSumOfOtaPerformancebyOTA(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate,
                                             @Param("otaId")Integer otaId);
    @Query(nativeQuery = true)
    OtaPerformanceDto getSumOfOtaGrossPerformancebyOTA(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate,
                                             @Param("otaId")Integer otaId);
    
    @Query(nativeQuery = true)
    List<OtaPerformanceDto> getSumOfOtaGrossPerformancebyOTAPickup(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate);
 
    @Query(nativeQuery = true)
    List<PickupTrendDto> findCurrentTrend(@Param("clientId") Integer clientId,
                                          @Param("startDate") Date startDate,
                                          @Param("endDate") Date endDate);
    
    @Query(nativeQuery = true)
    List<PickupTrendDto> findCurrentPerformanceTrend(@Param("clientId") Integer clientId,
                                          @Param("startDate") Date startDate,
                                          @Param("endDate") Date endDate);
    
    @Query(nativeQuery = true)
    List<PickupTrendDto> findSTLYCurrentPerformanceTrend(@Param("clientId") Integer clientId,
                                          @Param("startDate") Date startDate,
                                          @Param("endDate") Date endDate,
                                          @Param("monthDate") Date monthDate);
    
    @Query(nativeQuery = true)
    List<OccupancyByDateDto> findRoomSoldByOta(Integer clientId, Date startDate, Date endDate);

    @Query(nativeQuery = true)
    List<RPDADRDto> findRPDADR(@Param("clientId") Integer clientId,
                               @Param("startDate") Date startDate,
                               @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<RPDADRDto> findRPDADRForOTA(@Param("clientId") Integer clientId,
                                     @Param("startDate") Date startDate,
                                     @Param("endDate") Date endDate,
                                     @Param("otas") List<String> otas);

    @Query(nativeQuery = true)
    List<PercentileDto> getPercentile(
                                @Param("startDate") Date startDate,
                                @Param("endDate") Date endDate, @Param("clientId") Integer clientId);
    @Query(nativeQuery = true)
    List<PickupDto>
    findNewPickupByClientIdAndOccupancyDateAndSystemTodayAndStatus(@Param("clientId") Integer clientId,
                                                                                @Param("startDate") Date startDate,
                                                                                @Param("endDate") Date endDate, @Param("systemToday") Date systemToday);

    @Query(nativeQuery = true)
    List<PickupDto>
    findCancelPickupByClientIdAndOccupancyDateAndSystemTodayAndStatus(@Param("clientId") Integer clientId,
                                                                                @Param("startDate") Date startDate,
                                                                                @Param("endDate") Date endDate, @Param("systemToday") Date systemToday, @Param("status") List<String> status);



    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomAndClientByDateQueryA")
    List<PerformanceDto> findRevenueAndRoomAndClientByDateQueryA(Integer clientId, Date monthDate, Date fromDate, Date toDate);

    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomAndClientByDateQueryB")
    List<PerformanceDto> findRevenueAndRoomAndClientByDateQueryB(Integer clientId, Date monthDate, Date fromDate, Date toDate);

    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomAndClientByDateQueryAB")
    List<PerformanceDto> findRevenueAndRoomAndClientByDateQueryAB(Integer clientId, Date monthDate, Date fromDate, Date toDate);

    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomAndClientByDateQueryBC")
    List<PerformanceDto> findRevenueAndRoomAndClientByDateQueryBC(Integer clientId, Date monthDate, Date fromDate, Date toDate);

    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomAndClientByDateforMonth")
    List<PerformanceDto> findRevenueAndRoomAndClientByDateforMonth(Integer clientId, Date fromDate, Date toDate);
    
    @Query(nativeQuery = true, name = "Bookings.findRevenueAndRoomSTLMandSOTM")
    List<PerformanceDto> findRevenueAndRoomSTLMandSOTM(Integer clientId, Date fromDate, Date toDate,Date monthDate);
    
    
    List<BookingPaceOccupancyByDate> findByBookingIdAndClientId(Integer id, Integer clientId);
    
    List<BookingPaceOccupancyByDate> findByClientIdAndOccupancyDate(Integer clientId, Date occupancyDate);
    
    @Query(nativeQuery = true)
    List<PercentileDto> findByClientIdAndOccupancyDateAndCmStatus(@Param("clientId") Integer clientId,
    		@Param("occupancyDate") Date occupancyDate);

    List<BookingPaceOccupancyByDate> findByClientId(Integer clientId);

    @Transactional
    void deleteByBookingIdAndClientId(Integer id,Integer clientId);
    
    @Query(nativeQuery = true)
    List<OtaPerformanceDto> getSumOfOtaGrossPerformancebyOTAPickupforOTA(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate,@Param("otas") List<String> otas,
                                             @Param("fromDate") Date fromDate,@Param("toDate") Date toDate);
    @Query(nativeQuery = true)
    List<OtaPerformanceDto> getSumOfOtaGrossPerformancebyOTAPickupPieChartforOTA(@Param("clientId") Integer clientId,
                                             @Param("startDate") Date startDate,
                                             @Param("endDate") Date endDate,@Param("otas") List<String> otas);

}

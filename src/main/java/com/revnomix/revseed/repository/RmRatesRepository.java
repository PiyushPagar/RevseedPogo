package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revnomix.revseed.model.RmRates;
import com.revnomix.revseed.wrapper.CompetitorPricingDto;
import com.revnomix.revseed.wrapper.RateShopDto;
import com.revnomix.revseed.wrapper.RmRatesDto;
import com.revnomix.revseed.wrapper.analysis.CompetitorPricingAnalysisDto;
import com.revnomix.revseed.wrapper.analysis.OTAByCategoriesDto;
import com.revnomix.revseed.wrapper.analysis.RangeByCategoriesDto;

public interface RmRatesRepository extends JpaRepository<RmRates, Integer> {
    @Query(nativeQuery = true)
    List<CompetitorPricingDto> findAllCompetitorPricingByClientIdAndOccupancyDate(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true)
    List<CompetitorPricingDto> findMinAllCompetitorPricingByClientIdAndOccupancyDate(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("clientName") String clientName );

    @Query(nativeQuery = true)
    List<CompetitorPricingDto> findMinCompetitorsByClientIdAndOccupancyDate(@Param("clientId") Integer clientId, @Param("checkinDate") Date occupancyDate);

    @Query(nativeQuery = true)
    List<RangeByCategoriesDto> findRangeByRoomTypeCategories(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("roomTypeId") Integer roomTypeId);

    @Query(nativeQuery = true)
    List<OTAByCategoriesDto> findOTAByCategories(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("roomTypeId") Integer roomTypeId);

    @Query(nativeQuery = true)
    List<OTAByCategoriesDto> findOTAByCategoriesOTA(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("roomTypeId") Integer roomTypeId, @Param("otas")List<String> otas);

    @Query(nativeQuery = true)
    List<OTAByCategoriesDto> findOTAByCategoriesByClientId(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("roomTypeId") Integer roomTypeId);

    @Query(nativeQuery = true)
    List<CompetitorPricingAnalysisDto> findAllCompetitorByClientIdCategoryTypeId(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("roomCategoryTypeId") Integer roomCategoryTypeId,@Param("clientName") String clientName,@Param("otas")List<String> otas);

    @Query(nativeQuery = true)
    List<RmRatesDto> findAllCompetitorMinPricingByOta(@Param("clientId") Integer clientId, @Param("startDate") Date startDate, Integer clientRmCode);

    @Query(nativeQuery = true)
    List<RmRatesDto> findOneCompetitorMinPricingByOta(@Param("startDate") Date startDate, Integer clientRmCode);

    @Query(nativeQuery = true)
    List<CompetitorPricingDto> findCompetitorPricingDtos(@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("hotelCode")List<String> hotelCode, @Param("clientId") Integer clientId);

    RmRates findByUuid(String uuid);
    
    @Query(nativeQuery = true)
    List<RateShopDto> findByClientIdAndCheckinDate(@Param("clientId") Integer clientId,@Param("startDate") Date startDate,@Param("endDate") Date endDate,
    		@Param("currentDate") Date currentDate,@Param("hotelId") Integer hotelId,@Param("otaId") Integer otaId);
    
    List<RmRates> findByDateCollectedBetween(Date dateCollectedStr,Date dateCollectedEnd);
}

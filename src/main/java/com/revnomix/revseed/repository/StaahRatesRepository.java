package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.StaahRates;
import com.revnomix.revseed.wrapper.RateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StaahRatesRepository extends JpaRepository<StaahRates, Integer> {
    @Query(nativeQuery = true)
    List<RateDto> findAllRatesByClientIdAndRateDate(@Param("clientId") Integer clientId, @Param("startDate") Date startDate,@Param("endDate") Date endDate);
    //List<RateDto> findAllRecomendedRatesByClientIdAndRateDate(@Param("clientId") Integer clientId, @Param("startDate") Date startDate,@Param("endDate") Date endDate);
    StaahRates findOneByClientIdAndRateDateAndRoomTypeIdAndRateTypeId(Integer clientId, Date rateDate, Integer roomTypeId, Integer rateTypeId);
    StaahRates findByClientIdAndRateDateAndRoomTypeIdAndRateTypeId(Integer clientId, Date rateDate, Integer roomTypeId, Integer rateTypeId);
	List<StaahRates> findAllByClientIdAndRateDateGreaterThan(Integer clientId, Date date);

}


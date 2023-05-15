package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.OverrideFinal;
import com.revnomix.revseed.wrapper.OverrideFinalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface OverrideFinalRepository extends JpaRepository<OverrideFinal, Integer> {

    OverrideFinal findByClientId(Integer ClientId);
    OverrideFinal findByUpdateDateAndHotelId(Date updateDate, Integer HotelId);
    List<OverrideFinal> findByClientIdAndCheckinDateGreaterThanEqual(Integer clientId,Date checkinDate);
    @Query(nativeQuery = true)
    List<OverrideFinalDto> getLatestFinalValue(@Param("clientId") Integer clientId, Date startDate, Date endDate);
}

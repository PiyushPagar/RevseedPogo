package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revnomix.revseed.model.Override;
import com.revnomix.revseed.wrapper.OverrideDetailsDto;
import com.revnomix.revseed.wrapper.OverrideStrageyDto;

public interface OverrideRepository extends JpaRepository<Override, Integer> {

    List<Override> findByClientId(Integer ClientId);

    @Query(nativeQuery = true)
    List<OverrideDetailsDto> getLatestOverrideValue(@Param("clientId") Integer clientId, @Param("startDate")  Date startDate);

    @Query(nativeQuery = true)
    List<OverrideStrageyDto> getOverrideAlgoByDate(Integer clientId, Date fromDate, Date toDate);
    
    @Query(nativeQuery = true)
    List<OverrideStrageyDto> getOverrideAlgoByDateUserOnly(Integer clientId, Date fromDate, Date toDate);

    List<Override> findByHotelIdAndCheckinDate(int hotel_id, Date checkin_date);
    
    @Query(nativeQuery = true)
    List<OverrideDetailsDto>  getOverrideHistory (@Param("clientId") Integer clientId, @Param("occupancyDate")  Date startDate);
    Page<Override> findAll(Specification<T> example, Pageable page);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Override ov set ov.activeOverride =:updatedStatus where ov.clientId =:clientId AND overrideAlgo =:override_algo AND ov.activeOverride =:activeOverride")
    void disableOverride(@Param("activeOverride") String activeOverride,@Param("updatedStatus") String updatedStatus,@Param("override_algo") String override_algo, @Param("clientId") Integer clientId);

	List<Override> findByHotelId(Integer id);
}

package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.StaahRoomTypes;
import com.revnomix.revseed.wrapper.StaahRateTypeDto;
import com.revnomix.revseed.wrapper.StaahRoomTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository("staahRoomTypesRepository")
public interface StaahRoomTypesRepository extends JpaRepository<StaahRoomTypes, Integer> {
    StaahRoomTypes findOneByClientIdAndName(Integer clientId, String name);


    @Query(nativeQuery = true)
    List<StaahRoomTypeDto> findStaahRoomTypeDetails(Integer clientId);

    StaahRoomTypes findByStaahId(Integer roomTypeCode);
    
    @Query(nativeQuery = true)
    List<StaahRateTypeDto> getRateTypeByRoomTypeId(@Param("clientId") Integer clientId);

    List<StaahRoomTypes> findByClientId(Integer clientId);

    List<StaahRateTypeDto> findDistinctRoomTypes(Integer clientId);

    StaahRoomTypes findByClientIdAndStaahId(Integer id, Long roomId);

    StaahRoomTypes findByStaahIdAndClientId(Long roomTypeCode,Integer clientId);

	List<StaahRoomTypes> findAllByClientIdAndRegDateLessThan(Integer clientId, Date date);
}

package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.StaahRateTypes;
import com.revnomix.revseed.wrapper.StaahRateTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface StaahRateTypesRepository extends JpaRepository<StaahRateTypes, Integer> {

    List<StaahRateTypeDto> findDistinctStaahRateTypes(Integer clientId);
    StaahRateTypes findByClientIdAndStaahRateIdAndStaahRoomId(Integer id, Long rateId, Long roomId);
    StaahRateTypes findByClientIdAndStaahRoomIdAndRateId(Integer id, Long roomId, Long rateId);
    List<StaahRateTypes> findAllByClientId(Integer clientId);
    List<StaahRateTypes> findByClientIdAndStaahRoomId(Integer clientId,Long roomId);
    List<StaahRateTypes> findAllByClientIdAndRegDateLessThan(Integer clientId, Date date);
}

package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.DowDefinitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface DowDefinitionsRepository extends JpaRepository<DowDefinitions,Integer> {
    List<DowDefinitions> findByClientIdAndSeasonNo(Integer clientId, Integer seasonNo);
    List<DowDefinitions> findByClientIdAndSeasonNoAndType(Integer clientId, Integer seasonNo,String type);
    DowDefinitions findByClientIdAndSeasonNoAndDay(Integer clientId, Integer seasonNo,String day);
    List<DowDefinitions> findByClientId(Integer clientId);
    List<DowDefinitions> findByHotelId(Integer hotelId);
}

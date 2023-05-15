package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.SeasonalityDefinitions;

@Repository()
public interface SeasonalityDefinitionsRepository extends JpaRepository<SeasonalityDefinitions,Integer> {
    List<SeasonalityDefinitions> findByClientId(Integer clientId);
    List<SeasonalityDefinitions> findByClientIdAndStartWeekLessThanEqualAndEndWeekGreaterThanEqualAndStartWeekNot(Integer clientId,Integer startWeek,Integer endWeek, Integer zero);
    List<SeasonalityDefinitions> findByClientIdAndStartWeekGreaterThanEqualAndStartWeekNot(Integer clientId,Integer startWeek, Integer zero);
    List<SeasonalityDefinitions> findByClientIdAndEndWeekLessThanEqualAndStartWeekNot(Integer clientId,Integer endWeek, Integer zero);
    List<SeasonalityDefinitions> findByHotelId(Integer id);

}

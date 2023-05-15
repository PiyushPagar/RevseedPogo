package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.FinalRecommendations;
import com.revnomix.revseed.wrapper.OverrideDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinalRecommendationsRepository  extends JpaRepository<FinalRecommendations,Integer> {

    List<OverrideDetailsDto> getLatestFinalRateByClientId(Integer clientId);

	List<FinalRecommendations> findByHotelId(Integer id);
}

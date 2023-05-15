package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.RecommendationsToShow;
import com.revnomix.revseed.wrapper.OverrideFinalDto;

@Repository
public interface RecommendationToShowRepository extends JpaRepository<RecommendationsToShow, Long>  {

    @Query(nativeQuery = true)
    List<OverrideFinalDto> getRecommendationtoShow(@Param("clientId")Integer clientId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
    
    @Query(nativeQuery = true , value = "SELECT updated_date FROM recommendations_to_show where client_id = :clientId ORDER BY updated_date desc limit 1 ")
	public List<Date> findMaxCreationDatebyClientId(Integer clientId);

}

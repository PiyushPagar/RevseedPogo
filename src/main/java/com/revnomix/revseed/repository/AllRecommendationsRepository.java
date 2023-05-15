package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.AllRecommendations;
import com.revnomix.revseed.wrapper.OtaPerformanceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AllRecommendationsRepository extends JpaRepository<AllRecommendations, Integer> {
    @Query(nativeQuery = true)
    List<AllRecommendations> findAllRecommendationByClientIdAndCheckinDate(@Param("clientId") Integer clientId, @Param("checkinDate") Date checkinDate);

    @Query(nativeQuery = true)
    AllRecommendations findAllRecommendationByClientIdAndCheckinDateSingleDate(@Param("clientId") Integer clientId, @Param("checkinDate") Date checkinDate);
    
    @Query(nativeQuery = true , value = "SELECT creation_date FROM recommendations_all_by_date where client_id = :clientId ORDER BY creation_date desc limit 1 ")
	public List<Date> findMaxCreationDatebyClientId(Integer clientId);

	List<AllRecommendations> findByHotelId(Integer id);
}

package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revnomix.revseed.model.RecommendationCaliberationLog;

public interface RecommendationCaliberationLogRepository extends JpaRepository<RecommendationCaliberationLog, Long>  {

	List<RecommendationCaliberationLog> findByClientId(Long ClientId);
	
	List<RecommendationCaliberationLog> findByClientIdAndProcessType(Long ClientId,String processType);
	
    @Query(nativeQuery = true , value = "SELECT run_datetime FROM recom_calib_log where client_id = :clientId and process_type = :processType  ORDER BY run_datetime desc limit 1 ")
	public List<Date> findMaxCreationDatebyClientId(Long clientId,String processType);
}

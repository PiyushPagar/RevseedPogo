package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revnomix.revseed.model.Clients;
import com.revnomix.revseed.model.MonitoringDasboard;

public interface MonitoringDasboardRepository extends JpaRepository<MonitoringDasboard, Integer>{

	Page<MonitoringDasboard> findAll (Pageable pageable);
	List<MonitoringDasboard> findByStatus(String status);
    @Query(value = "SELECT COUNT(id) FROM Clients")
	public int countAll();
	Page<MonitoringDasboard> findByStatus(String status, Pageable pageable);
	Page<MonitoringDasboard> findByRatePushEnable(Boolean ratePush, Pageable pageable);
	Page<MonitoringDasboard> findByStatusAndRatePushEnable(String status, Boolean ratePush, Pageable pageable);
}

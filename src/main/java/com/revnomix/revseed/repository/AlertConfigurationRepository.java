package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.AlertConfiguration;

public interface AlertConfigurationRepository extends JpaRepository<AlertConfiguration, Integer> {
	
	List<AlertConfiguration> findByAccountIdAndStatus(Integer accountId,String status);
	AlertConfiguration findByAccountIdAndStatusAndAlertType(Integer accountId,String status,String alertType);
	AlertConfiguration findByAccountIdAndAlertType(Integer accountId,String alertType);
	List<AlertConfiguration> findByAccountId(Integer accountId);
	Page<AlertConfiguration> findAll(Specification<T> example, Pageable page);
	AlertConfiguration findByClientIdAndAlertType(Integer clientId, String alertType);
	List<AlertConfiguration> findByClientId(Integer clientId);
	List<AlertConfiguration> findByClientIdAndStatus(Integer clientId,String status);
	AlertConfiguration findByClientIdAndStatusAndAlertType(Integer clientId,String status,String alertType);
}

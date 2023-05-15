package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.AlertLogs;

public interface AlertsLogRepository extends JpaRepository<AlertLogs, Integer> {
	
	List<AlertLogs> findByClientIdAndStatus(Integer accountId,String status);
	List<AlertLogs> findByClientIdAndStatusAndType(Integer accountId,String status,String type);
	Page<AlertLogs> findAll(Specification<T> example, Pageable page);
	List<AlertLogs> findByAccountIdAndStatusAndType(Integer accountId, String active, String code);
	
	
	
}

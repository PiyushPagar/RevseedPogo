package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.AlertConditionType;

public interface AlertConditionTypeRepository extends JpaRepository<AlertConditionType, Integer> {
	
	List<AlertConditionType> findByConfigId(Integer configId);
	List<AlertConditionType> findByConfigIdAndStatus(Integer configId,String Status);
	Page<AlertConditionType> findAll(Specification<T> example, Pageable page);
}

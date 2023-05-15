package com.revnomix.revseed.repository;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.AlertType;
public interface AlertTypeRepository extends JpaRepository<AlertType, Integer> {
	
	AlertType findByCodeAndStatus(String code,String status);
	Page<AlertType> findAll(Specification<T> example, Pageable page);
}

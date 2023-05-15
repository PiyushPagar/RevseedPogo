package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revnomix.revseed.model.ScheduledJob;
import com.revnomix.revseed.wrapper.ScheduledJobDto;

public interface ScheduledJobRepository extends JpaRepository<ScheduledJob,Integer> {
    @Query(nativeQuery = true)
    List<ScheduledJobDto> findByStatus(Integer clientId,Date startDate);
    @Query(nativeQuery = true)
    List<ScheduledJobDto> getPropertyDetails(Date startDate, Integer clientId,  String Status);
    Page<ScheduledJob> findAll(Specification<T> example, Pageable page);
	
}

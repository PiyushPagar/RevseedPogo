package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.CountryStateCity;

@Repository
public interface CountryStateCityRepository extends JpaRepository<CountryStateCity,Integer>  {
	
	public List<CountryStateCity> findByParentSts(CountryStateCity parentSts);
	public List<CountryStateCity> findByType(String type);
	public List<CountryStateCity> findByTypeAndParentSts(String type,CountryStateCity parentSts);
	public List<CountryStateCity> findByTypeAndNameIgnoreCaseContainingAndStatus(String type,String name,String status);
	public List<CountryStateCity> findByTypeAndNameIgnoreCaseContainingAndParentStsAndStatus(String type,String name,CountryStateCity parentSts,String status);
	public List<CountryStateCity> findByTypeAndNameIgnoreCaseContainingAndParentSts(String type,String name,CountryStateCity parentSts);
	public Page<CountryStateCity> findAll(Specification<T> example, Pageable page);

}

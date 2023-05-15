package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.UILayout;

public interface UILayoutRepository extends JpaRepository<UILayout, Integer>{

	public List<UILayout> findByParent(UILayout parentLayout);
	public List<UILayout> findByLayoutType(String layoutType);
	public List<UILayout> findByLayoutTypeAndParent(String layoutType,UILayout parentLayout);
	public List<UILayout> findByLayoutTypeAndNameIgnoreCaseContaining(String layoutType,String name);
	public List<UILayout> findByLayoutTypeAndNameIgnoreCaseContainingAndParent(String layoutType,String name,UILayout parentLayout);
	public Page<UILayout> findAll(Specification<T> example, Pageable page);

}

package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.Permissions;
import com.revnomix.revseed.model.UILayout;

public interface PermissionsRepository extends JpaRepository<Permissions, Integer>{

	public List<Permissions> findByAccountIdAndStatus(Integer accountId,String status);
	public List<Permissions> findByAccountIdAndClientIdAndStatus(Integer accountId,Integer clientId,String status);
	public List<Permissions> findByRoleCustomAndStatus(String role,String status);
	public Page<Permissions> findAll(Specification<T> example, Pageable page);
	public List<Permissions> findByAccountIdAndStatusAndUiLayoutId(Integer accountId,String status,UILayout uiLayout);
	public List<Permissions> findByRoleCustomAndStatusAndUiLayoutIdIn(String position, String active,  List<UILayout> layoutList);
	public List<Permissions> findByAccountIdAndClientIdAndStatusAndUiLayoutIdIn(Integer id, Integer clientId,
			String active, List<UILayout> layoutList);
}

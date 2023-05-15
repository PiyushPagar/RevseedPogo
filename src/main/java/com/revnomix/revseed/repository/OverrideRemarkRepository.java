package com.revnomix.revseed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.OverrideRemark;

public interface OverrideRemarkRepository extends JpaRepository<OverrideRemark, Integer> {

	OverrideRemark findByOverrideId(Integer overrideId);
}

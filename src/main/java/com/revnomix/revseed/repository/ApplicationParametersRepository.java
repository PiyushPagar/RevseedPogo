package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.ApplicationParameters;

@Repository
public interface ApplicationParametersRepository extends JpaRepository<ApplicationParameters, Integer>{
	List<ApplicationParameters> findByStatus(Boolean Status);
	List<ApplicationParameters> findByStatusAndCode(Boolean Status,String Code);
	List<ApplicationParameters> findByStatusAndParentCode(Boolean Status,String parentCode);
	List<ApplicationParameters> findByStatusAndCodeType(Boolean Status, String codeType);
	ApplicationParameters findOneByCode(String code);
	ApplicationParameters findByStatusAndCodeAndParentCode(Boolean Status,String Code, String parentCode);
}

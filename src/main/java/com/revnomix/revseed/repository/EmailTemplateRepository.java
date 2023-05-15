package com.revnomix.revseed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revnomix.revseed.model.EmailTemplate;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate,Integer>{

	EmailTemplate findByTemplateCodeAndStatus (String templateCode,Boolean status);
	
}

package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.PropertyConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyConfigurationRepository extends JpaRepository<PropertyConfiguration, Integer> {
}


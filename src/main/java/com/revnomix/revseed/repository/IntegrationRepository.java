package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Integration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegrationRepository extends JpaRepository<Integration,Integer> {
}

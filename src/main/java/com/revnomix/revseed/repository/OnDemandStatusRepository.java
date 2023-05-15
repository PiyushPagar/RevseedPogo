package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.OnDemandStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OnDemandStatusRepository extends JpaRepository<OnDemandStatus,Integer> {

    Optional<OnDemandStatus> findByClientIdAndServiceType(Integer clientId, String serverType);
}

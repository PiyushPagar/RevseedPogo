package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.ClientDemandProcessingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientOnDemandRepository extends JpaRepository<ClientDemandProcessingStatus,Integer> {

    Optional<ClientDemandProcessingStatus> findByClientId(Integer clientId);
}

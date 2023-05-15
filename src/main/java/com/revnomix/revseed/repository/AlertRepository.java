package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Alert;
import com.revnomix.revseed.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Integer> {
    List<Alert> findAlertByClientIdAndStatusIsNot(Integer clientId, Status status);
}

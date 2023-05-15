package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Integer> {

}

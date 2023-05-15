package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.CompletedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedMessageRepository extends JpaRepository<CompletedMessage, String> {
}

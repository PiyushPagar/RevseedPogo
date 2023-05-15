package com.revnomix.revseed.repository;


import com.revnomix.revseed.model.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorMesssageRepository extends JpaRepository<ErrorMessage, String> {
}

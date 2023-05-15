package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.RmRoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmRoomTypesRepository extends JpaRepository<RmRoomTypes, Integer> {
    RmRoomTypes findOneBySlug(String slug);
}


package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.RoomTypes;

@Repository()
public interface RoomTypesRepository extends JpaRepository<RoomTypes,Integer> {
    List<RoomTypes> findByNameContaining(String keywords);
    RoomTypes findByName(String name);
    Page<RoomTypes> findAll(Specification<T> example, Pageable page);
    List<RoomTypes> findByStatusOrStatusIsNull(String status);

}

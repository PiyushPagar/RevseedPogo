package com.revnomix.revseed.repository;

import java.util.List;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Hotels;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels, Integer> {

    List<Hotels> findByNameContainingAndCityInAndStatus(String name, List<String> lstCity,String status);
    
    @Query(nativeQuery = true, value = "SELECT * FROM revseed.hotels WHERE rm_code like %?1% and city in ?2 and status = ?3")
    List<Hotels> findByNameContainAndCityAndStatus(Integer rmCode, List<String> lstCity,String status);

    Hotels findByNameAndCityInAndStatus(String name, List<String> lstCity, String status);
    
    Hotels findByNameAndCityInAndRmCodeAndStatus(String name,  List<String> lstCity,Integer rmcode,String status);

    List<Hotels> findByIdIn(List<Integer> hotelIds);

    List<Hotels> findByNameContainingAndStatus(String keywords,String status);
    
    @Query(nativeQuery = true, value = "SELECT * FROM revseed.hotels WHERE rm_code like %?1% and status = ?2")
    List<Hotels> findByRmCodeContainAndStatus(Integer rmCode, String status);

    Hotels findByRmCode(Integer hotelCode);
    
    Hotels findOneById(Integer hotelId);

    Hotels findRmCodeByClientId(Integer clientId);

    List<Hotels> findByIdInOrderByFirstClient(List<Integer> ids, String clientName);

	Page<Hotels> findAll(Specification<T> example, Pageable page);

	Hotels findByNameAndCityInAndRmCode(String name, List<String> name2, Integer rmCode);
}


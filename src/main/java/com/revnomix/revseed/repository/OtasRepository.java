package com.revnomix.revseed.repository;


import com.revnomix.revseed.model.Otas;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("otaRepository")
public interface OtasRepository extends JpaRepository<Otas,Integer> {
    List<Otas> findByNameContaining(String name);

    Optional<Otas> findByNameOrDomainName(String name, String domainName);

    @Query(nativeQuery = true)
    List<Otas> findForBookings(@Param("clientId") Integer clientId);

    @Query(nativeQuery = true)
    List<Otas> findForBookingsForAllClients();

    @Query(nativeQuery = true)
    List<Otas> findByClientId(@Param("clientId") Integer clientId);

    Otas findOneByName(String channel);

    @Query()
    List<Otas> findByIntegrationType( String type);

    //List<Otas> findByClientIdAndStatusOrStatusIsNull(Integer clientId, RowStatus status);

    List<Otas> findByStatusOrStatusIsNull(String status);

    List<Otas> findByIdAndStatus(Integer id ,String status);

    Page<Otas> findAll(Specification<T> example, Pageable page);

}

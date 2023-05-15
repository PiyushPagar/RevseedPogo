package com.revnomix.revseed.repository;

import java.util.List;


import java.util.Optional;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Accounts;

@Repository("accountsRepository")
public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
    List<Accounts> findByClientId(Integer clientId);
    List<Accounts> findByClientIdAndPosition(Integer clientId,String role);
    Accounts findByEmail(String accountEmail);
    Accounts findByEmailAndStatus(String accountEmail,String Status);
    Optional<Accounts> findAllByEmail(String accountEmail);
    List<Accounts> findByStatusAndPosition(String Status,String role);
    List<Accounts> findByStatusAndPositionIn(String Status, List<String> roleList);
	Page<Accounts> findAll(Specification<T> example, Pageable page);
	List<Accounts> findByStatus(String status);
}

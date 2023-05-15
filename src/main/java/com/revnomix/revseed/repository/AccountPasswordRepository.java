package com.revnomix.revseed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.AccountPassword;

@Repository
public interface AccountPasswordRepository extends JpaRepository<AccountPassword,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM account_password order by created_date DESC limit 10;")
    Optional<List<AccountPassword>> findAllByCreatedDate();
    List<AccountPassword> findByUserId(Integer userId);
}

package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.LoginDetail;
import com.revnomix.revseed.model.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDetail,Integer> {

    List<LoginDetail> findAllByAccountIdAndStatus(Integer accountId, RowStatus status);

    @Query(nativeQuery = true, value = "SELECT * FROM login_detail where account_id = :accountId order by check_in desc ")
    Optional<List<LoginDetail>> findByAccountId(Integer accountId);

}

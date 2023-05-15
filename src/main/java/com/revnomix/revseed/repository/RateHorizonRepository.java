package com.revnomix.revseed.repository;


import com.revnomix.revseed.model.RateHorizon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository()
public interface RateHorizonRepository extends JpaRepository <RateHorizon, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM rate_horizon where client_id= :clientId and date = date( :date ) and pace_point= :pacePoint and status= :status")
    RateHorizon findByClientIdAndDateAndPacePointAndStatus(Integer clientId, Date date,Integer pacePoint, String status);

    //@Query(nativeQuery = true, value = "select date(date_sub(date, interval pace_point day)) as checkin, algo from rate_horizon where client_id = :clientId")
    List<RateHorizon> findAllByClientIdAndStatus(Integer clientId, String status);

    List<RateHorizon> findByClientIdAndStatus(Integer clientId, String status);

    @Query(nativeQuery = true, value = "SELECT * FROM rate_horizon where client_id= :clientId and date = date( :date ) and (pace_point between :startPace and :endPace) and status= :status")
    List<RateHorizon> findAllByClientIdAndDateAndPacePointBetweenAndStatus(Integer clientId, Date date, Integer startPace, Integer endPace,String status);
}

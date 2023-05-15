package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Events;
import com.revnomix.revseed.model.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer> {

    List<Events> findByClientId(Integer clientId);

    List<Events> findByClientIdAndStatusOrStatusIsNull(Integer clientId, RowStatus status);

    List<Events> findByStatusOrStatusIsNull(RowStatus status);

    List<Events> findByClientIdAndStartDateGreaterThanEqual(Integer clientId, Date startDate);

    List<Events> findByClientIdAndStartDate(Integer clientId, Date eventDate);

    List<Events> findByClientIdAndEndDateGreaterThanEqualAndStatus(Integer clientId, Date systemToday, RowStatus active);

    List<Events> findByClientIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatus(Integer clientId,Date startDate, Date endDate, RowStatus active);
    
    List<Events> findByStatus(RowStatus active);

    @Query(nativeQuery = true, value = "select * from events e where :startDate <= e.end_date and :endDate >= e.start_date and e.client_id= :clientId ")
    Optional<List<Events>> findAllByStartDateGreaterThanEqualAndEndDatelessThanEqualAndClientId(Date startDate, Date endDate, Integer clientId);

}

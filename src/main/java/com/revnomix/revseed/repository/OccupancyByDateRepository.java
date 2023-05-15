package com.revnomix.revseed.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.OccupancyByDate;

@Repository
public interface OccupancyByDateRepository extends JpaRepository<OccupancyByDate, Integer> {

    OccupancyByDate findByClientIdAndOccupancyDateAndOtaIdAndCmRoomId(Integer clientId, Date occDate, Integer otaId, Long cmId);

	List<OccupancyByDate> findByHotelId(Integer id);
}

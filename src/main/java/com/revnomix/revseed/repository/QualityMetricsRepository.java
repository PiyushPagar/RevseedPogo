package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.ClientsQM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository()
public interface QualityMetricsRepository extends JpaRepository<ClientsQM, Integer> {
     @Query(nativeQuery = true)
     List<ClientsQM> getAllHotelsNameAndOtaNameByQualityMetrics(@Param("clientId") Integer ClientId);
     List<ClientsQM> findByClientId(Integer ClientId);
     List<ClientsQM> findByHotelId(Integer hotelId);
}

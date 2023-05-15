package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Clients;
import com.revnomix.revseed.model.Competitors;
import com.revnomix.revseed.model.Hotels;

@Repository()
public interface CompetitorsRepository extends JpaRepository<Competitors,Integer> {
    List<Competitors> findByClientId(Integer clientId);
    
    @Query(nativeQuery = true)
    List<Clients> findClientsByHotelId(Integer hotelId);

    @Query(nativeQuery = true)
    List<Hotels> findAllCompetitorsForClient(@Param("clientId") Integer clientId);

    @Query(nativeQuery = true)
    List<Hotels> findAllSuggestedCompetitorsByDistance(@Param("clientId") Integer clientId);

//    List<Competitors> findByClientIdAndHotelIdIn(int client_id, int hotel_id);

    @Query(nativeQuery = true)
    List<Hotels> findAllHotelsForQM(@Param("clientId") Integer Id);
}

package com.revnomix.revseed.repository;


import com.revnomix.revseed.model.ClientsCompetitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface ClientCompetitorsRepository extends JpaRepository<ClientsCompetitors,Integer> {
    List<ClientsCompetitors> findByClientId(Integer clientId);
    List<ClientsCompetitors> findByClientIdAndHotelId(Integer clientId,Integer hotelId);
	List<ClientsCompetitors> findByHotelId(Integer hotelId);
}

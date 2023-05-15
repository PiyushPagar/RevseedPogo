package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.HotelChains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelChainsRepository extends JpaRepository<HotelChains, Integer> {
    List<HotelChains> findAllByClientId(Integer clientId);
}

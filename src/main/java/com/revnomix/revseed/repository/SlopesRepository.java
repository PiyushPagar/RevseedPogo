package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Slopes;

@Repository()
public interface SlopesRepository  extends JpaRepository<Slopes, Integer> {

	List<Slopes> findByHotelId(Integer id);
	List<Slopes> findByClientId(Integer ClientId);
}
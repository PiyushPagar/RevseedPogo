package com.revnomix.revseed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Intercepts;

@Repository()
public interface InterceptsRepository  extends JpaRepository<Intercepts, Integer> {

	List<Intercepts> findByHotelId(Integer id);
	List<Intercepts> findByClientId(Integer ClientId);
}

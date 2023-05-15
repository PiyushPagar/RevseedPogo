package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Clients;

@Repository()
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    Clients findByHotelId(Integer hotelId);
    Page<Clients> findAll (Pageable pageable);
    List<Clients> findByStatusOrStatusIsNull(String status);
    @Query(value = "SELECT COUNT(id) FROM Clients")
	public int countAll();
    Clients findOneByCmHotel(Integer cmHotelId);
    Clients findByCmHotel(Integer cmHotelId);
    Clients findBycmPassword(Integer cmPassword);
    Clients findOneById (Integer clientId);
    Clients findOneByCmHotelAndStatus(Integer cmHotelId, String status);
    List<Clients> findByStatus(String status);
    List<Clients> findAllByStatusAndChannelManager(String status, String channelManager);
    List<Clients> findAllByStatusAndPropertyNameContainingIgnoreCase(String status, String propertyName);
    Clients findOneByPropertyName (String propertyName);
    List<Clients> findAllByStatusAndIdIn (String status, List<Integer> id);
	Page<Clients> findByStatus(String status, Pageable pageable);
	Page<Clients> findByRatePushEnable(Boolean ratePush, Pageable pageable);
	Page<Clients> findByStatusAndRatePushEnable(String status, Boolean ratePush, Pageable pageable);
	Clients findOneByIdAndStatus (Integer clientId,String status);
	Page<Clients> findAll(Specification<T> example, Pageable page);
}

package com.revnomix.revseed.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.BookingStatusMapping;

@Repository()
public interface BookingStatusMappingRepository extends JpaRepository<BookingStatusMapping,Integer>  {

	 List<BookingStatusMapping> findByBookingStatusAndChannelManagerAndStatus(String bookingStatus, String channelManager,String status);
	 List<BookingStatusMapping> findByBookingStatusAndChannelManager(String bookingStatus, String channelManager);
	 List<BookingStatusMapping> findByChannelManager(String channelManager);
	 Page<BookingStatusMapping> findAll(Specification<T> example, Pageable page);

}

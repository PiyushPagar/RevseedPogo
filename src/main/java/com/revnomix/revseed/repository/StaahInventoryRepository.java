package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.StaahInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StaahInventoryRepository extends JpaRepository<StaahInventory, Integer> {
    Optional<StaahInventory> findByClientIdAndRoomTypeIdAndInvDate( Integer clientId, Integer staahRoomId ,Date invDate);
    List<StaahInventory> findAllByClientIdAndRoomTypeIdAndInvDate(Integer clientId, Integer staahRoomId , Date invDate);
    List<StaahInventory> findAllByClientIdAndInvDate(Integer clientId , Date invDate);
    StaahInventory findByClientIdAndInvDateAndRoomTypeId(Integer clientId,Date invDate, Integer staahRoomId);
	List<StaahInventory> findAllByClientIdAndInvDateLessThan(Integer clientId, Date invDate);
	List<StaahInventory> findAllByClientId(Integer clientId);
}

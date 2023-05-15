package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.RoomTypeMappings;
import com.revnomix.revseed.model.StaahRoomTypes;
import com.revnomix.revseed.wrapper.RoomTypeMappingsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roomTypeMappingsRepository")
public interface RoomTypeMappingsRepository extends JpaRepository<RoomTypeMappings,Integer> {
    @Query(nativeQuery = true)
    List<RoomTypeMappings> findAllRatesByClientIdAndRateDate(@Param("clientId") Integer clientId);
    @Query(nativeQuery = true)
    List<RoomTypeMappingsDto> findAllRatesMappings();

    RoomTypeMappings findOneByClientIdAndClientRoomType(Integer clientId,Long clientRoomType);
    List<RoomTypeMappings> findByClientId(Integer clientId);
    RoomTypeMappings findByClientRoomTypeAndClientId(Long clientRoomType,Integer clientId);

    RoomTypeMappings findByClientRoomTypeAndClientIdAndType(Integer id, int clientId, String staah);

    RoomTypeMappings findByClientRoomType(Integer roomTypeCode);
}

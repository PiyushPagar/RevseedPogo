package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.BookingStatusMapping;
import com.revnomix.revseed.model.OtaMappings;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("otaMappingsRepository")
public interface OtaMappingsRepository extends JpaRepository<OtaMappings, Integer> {
    List<OtaMappings> findByClientId(Integer clientId);
    List<OtaMappings> findAllByClientIdAndClientOtaAndType(Integer clientId, String ota , String type);
    OtaMappings findFirstByClientIdAndTypeAndClientOta(Integer clientId,String type,String clientOta);
    List<OtaMappings> findByClientOta(String clientOta);
    List<OtaMappings> findByClientIdAndClientOtaIn(Integer clientId, List<String> clientOta);
    OtaMappings findFirstByClientIdAndOtaId(Integer clientId,Integer otaId);
    OtaMappings findFirstByTypeAndClientOta(String type, String clientOta);
    Page<OtaMappings> findAll(Specification<T> example, Pageable page);
	OtaMappings findFirstByClientIdAndClientOta(Integer clientId, String clientOta);
}

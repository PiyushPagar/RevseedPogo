package com.revnomix.revseed.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revnomix.revseed.model.Accounts;
import com.revnomix.revseed.model.AlertLogs;
import com.revnomix.revseed.model.AlertType;
import com.revnomix.revseed.model.BookingStatusMapping;
import com.revnomix.revseed.model.Clients;
import com.revnomix.revseed.model.CountryStateCity;
import com.revnomix.revseed.model.Hotels;
import com.revnomix.revseed.model.OtaMappings;
import com.revnomix.revseed.model.Otas;
import com.revnomix.revseed.model.Permissions;
import com.revnomix.revseed.model.RoomTypes;
import com.revnomix.revseed.model.ScheduledJob;
import com.revnomix.revseed.model.UILayout;


@Service
public interface CustomRepository {

	Page<Clients> findClientByConditions(String status, Boolean ratePushEnable, String runCaliberation,
			String runRecommendation, String channelManager,List<Integer> accountManager, Pageable page, Accounts acc);
	
	Page<Hotels> findHotelsByConditions(Integer pagenum, Integer pagesize, String status, Integer rmcode, Integer id,String name, Pageable page);

	Page<Accounts> findAccountsByConditions(Integer pagenum, Integer pagesize, String status, String firstname,
			Integer id, String lastname, String mobile, String email, Integer clientId, Pageable pageable);

	Page<AlertLogs> findAlertsByConditions(Integer pagenum, Integer pagesize, Integer accountId,Integer clientId, String body,
			String subject, String status,String readStatus,List<String> type, Pageable page);
	
	Page<ScheduledJob> findScheduledJobByConditions(Integer pagenum, Integer pagesize, Integer clientId, String jobType,
			Date startDateTime,Date endDateTime, String status, Pageable page);

	Page<AlertType> findAlertTypeByConditions(Integer pagenum, Integer pagesize, String code, String status,
			Pageable page);

	Page<UILayout> findUILayoutByConditions(Integer pagenum, Integer pagesize, String name, String status,
			Pageable pageable);

	Page<Permissions> findPermissionsByConditions(Integer pagenum, Integer pagesize, String roleCustom,
			Boolean isEditable, Integer accountId, Integer clientId, String status, Boolean isPredefined, String name, String type, Pageable pageable) throws Exception;

	Page<Permissions> findPermissionsReportByConditions(Integer pagenum, Integer pagesize, String roleCustom,
			Integer accountId, String status, Pageable pageable);

	Page<CountryStateCity> findCountryStateCityByConditions(Integer pagenum, Integer pagesize, String name, String type,
			String status, Pageable pageable);
	
	Page<RoomTypes> findRoomTypesByConditions(Integer pagenum, Integer pagesize, String name,
			String status, Pageable pageable);
	
	Page<Otas> findOTAByConditions(Integer pagenum, Integer pagesize, String name,String domainName,
			String status, Pageable pageable);

	Page<com.revnomix.revseed.model.Override> findOverridesByConditions(Integer pagenum, Integer pagesize, Integer clientId, String algo,
			Date startOverrideDateTime, Date endOverrideDateTime, Date startCheckinDateTime, Date endCheckinDateTime,
			String status, List<Integer> overriddenBy, Pageable page);

	Page<BookingStatusMapping> findBookingStatusMapList(Integer pagenum, Integer pagesize, String bookingstatus,
			String channel, String status, Pageable pageable);

	Page<OtaMappings> findOtaMappingByConditions(Integer pagenum, Integer pagesize, String clientOta, String type,
			Integer otaId, Integer clientId ,String unmappedOTAs, Pageable pageable);
}

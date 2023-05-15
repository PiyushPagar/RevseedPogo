package com.revnomix.revseed.repository;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.Accounts;
import com.revnomix.revseed.model.AlertLogs;
import com.revnomix.revseed.model.AlertType;
import com.revnomix.revseed.model.BookingStatusMapping;
import com.revnomix.revseed.model.Clients;
import com.revnomix.revseed.model.CountryStateCity;
import com.revnomix.revseed.model.Hotels;
import com.revnomix.revseed.model.JobType;
import com.revnomix.revseed.model.OtaMappings;
import com.revnomix.revseed.model.Otas;
import com.revnomix.revseed.model.Permissions;
import com.revnomix.revseed.model.RoomTypes;
import com.revnomix.revseed.model.ScheduledJob;
import com.revnomix.revseed.model.Status;
import com.revnomix.revseed.model.UILayout;

@Repository
@EnableJpaRepositories
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	EntityManager em;
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private HotelsRepository hotelRepository;
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private AlertsLogRepository alertsLogRepository;
    @Autowired
    private ScheduledJobRepository scheduledJobRepository;
    @Autowired
    private OverrideRepository overrideRepository;
    @Autowired
    private AlertTypeRepository alertTypeRepository;
    @Autowired
    private UILayoutRepository uiLayoutRepository;
    @Autowired
    private PermissionsRepository permissionRepository;
    @Autowired
    private CountryStateCityRepository countryStateCityRepository;
    @Autowired
    private RoomTypesRepository roomTypesRepository;
    @Autowired
    private OtasRepository otasRepository;
    @Autowired
    private BookingStatusMappingRepository bookingStatusMappingRepository;
    
    @Autowired
    OtaMappingsRepository otaMappingsRepository;
    
    
	@Override
	public Page<Clients> findClientByConditions(String status, Boolean ratePushEnable, String runCaliberation, String runRecommendation,String channelManager,List<Integer> accountManager, Pageable page,Accounts acc) {
		
	     Page<Clients> pager = clientsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicatesList = new ArrayList<>();
	                         //name fuzzy query, like statement
	            if (status != null && !status.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("status"), status )));
	            }
	                         // itemPrice is less than or equal to <= statement
	            if (ratePushEnable != null && !ratePushEnable.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("ratePushEnable"), ratePushEnable)));
	            }
	                         //itemStock is greater than or equal to >= statement
	            if (runCaliberation != null && !runCaliberation.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("runCalibration"), runCaliberation)));
	            }
	            
	            if (channelManager != null && !channelManager.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("channelManager"), channelManager)));
	            }
	            
	            if (accountManager != null && accountManager.size()>0) {
	            	predicatesList.add(
	                        criteriaBuilder.and(
	                                        root.get("accountManager").in(accountManager)));
	            }
	            
	            if (runRecommendation != null && !runRecommendation.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("runRecommendation"), runRecommendation)));
	            }
	            if (acc.getPropertyIds().size() > 0) {
	            	predicatesList.add(
	                        criteriaBuilder.and(
	                                        root.get("id").in(acc.getPropertyIds())));
	            }
	            return criteriaBuilder.and(
	                    predicatesList.toArray(new Predicate[predicatesList.size()]));
	        }, page);
	    return pager;
	}


	@Override
	public Page<Hotels> findHotelsByConditions(Integer pagenum, Integer pagesize, String status, Integer rmCode,
			Integer id,String name, Pageable page) {
	     Page<Hotels> pager = hotelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicatesList = new ArrayList<>();
	            if (status != null && !status.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("status"), status )));
	            }
	            if (rmCode != null && !rmCode.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("rmCode"), rmCode)));
	            }
	            if (id != null && !id.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("id"), id)));
	            }
	            if (name != null && !name.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                        root.get("name"), "%"+name+"%")));
	            }
	            return criteriaBuilder.and(
	                    predicatesList.toArray(new Predicate[predicatesList.size()]));
	        }, page);
	    return pager;
	}


	@Override
	public Page<Accounts> findAccountsByConditions(Integer pagenum, Integer pagesize, String status, String firstname,
			Integer id, String lastname, String mobile, String email, Integer clientId, Pageable page) {
		Page<Accounts> pager = accountsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (mobile != null && !mobile.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("mobile1"), "%"+mobile+"%")));
            }
            if (id != null && !id.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("accountId"), id)));
            }
            if (firstname != null && !firstname.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("accountFirstName"), "%"+firstname+"%")));
            }
            if (lastname != null && !lastname.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("accountLastName"), "%"+lastname+"%")));
            }
            if (email != null && !email.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("email"), "%"+email+"%")));
            }
            if (clientId != null && !clientId.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("clientId"),clientId)));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, page);
    return pager;
	}
	
	@Override
	public Page<AlertLogs> findAlertsByConditions(Integer pagenum, Integer pagesize, Integer accountId, Integer clientId, String body,
			String subject,String status,String readStatus,List<String> type, Pageable page) {
	     Page<AlertLogs> pager = alertsLogRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicatesList = new ArrayList<>();
	            if (status != null && !status.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("status"), status )));
	            }
	            if (subject != null && !subject.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                        root.get("subject"),"%"+subject+"%")));
	            }
	            if (accountId != null ) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("accountId"), accountId)));
	            }
	            if (clientId != null ) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("clientId"), clientId)));
	            }
	            if (body != null && !body.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                        root.get("body"), "%"+body+"%")));
	            }
	            if (readStatus != null && !readStatus.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("readStatus"), readStatus )));
	            }
	            if (type != null && type.size()>0) {
	                predicatesList.add(
	                        criteriaBuilder.and(root.get("type").in(type)));
	            }
	            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));         
	            return criteriaBuilder.and(
	                    predicatesList.toArray(new Predicate[predicatesList.size()]));
	        }, page);
	    return pager;
	}
	
	@Override
	public Page<AlertType> findAlertTypeByConditions(Integer pagenum, Integer pagesize, String name, String status, Pageable page) {
	     Page<AlertType> pager = alertTypeRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicatesList = new ArrayList<>();
	            if (status != null && !status.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("status"), status )));
	            }
	            if (name != null && !name.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                        root.get("name"),"%"+name+"%")));
	            }
	            return criteriaBuilder.and(
	                    predicatesList.toArray(new Predicate[predicatesList.size()]));
	        }, page);
	    return pager;
	}


	@Override
	public Page<ScheduledJob> findScheduledJobByConditions(Integer pagenum, Integer pagesize, Integer clientId,
			String jobType, Date startDateTime,Date endDateTime, String status, Pageable page) {
		Page<ScheduledJob> pager = scheduledJobRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"),Status.valueOf(status))));
            }
            if (startDateTime != null) { predicatesList.add( criteriaBuilder.and(
			  criteriaBuilder.greaterThanOrEqualTo( root.get("startDateTime").as(Date.class),new java.util.Date(startDateTime.getTime()))));
			} 
            
            if (endDateTime != null) { predicatesList.add( criteriaBuilder.and(
			  criteriaBuilder.lessThanOrEqualTo( root.get("endDateTime").as(Date.class),new java.util.Date(endDateTime.getTime())))); 
			}
			 
            if (clientId != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("clientId"), clientId)));
            }
            if (jobType != null && !jobType.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("jobType"), JobType.valueOf(jobType) )));
            }
            criteriaQuery.orderBy(
                    criteriaBuilder.desc(root.get("startDateTime")));
            
           // List<Discount> list = em.createQuery(criteriaQuery).setParameter(startDate, startDateTime, TemporalType.DATE)
           // .setParameter(endDate, endDateTime, TemporalType.DATE).getResultList();
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, page);
		
    return pager;
	}

	
	@Override
	public Page<com.revnomix.revseed.model.Override> findOverridesByConditions(Integer pagenum, Integer pagesize, Integer clientId,
			String algo, Date startOverrideDateTime,Date endOverrideDateTime, Date startCheckinDateTime,Date endCheckinDateTime, String status,List<Integer> overriddenBy, Pageable page) {
		Page<com.revnomix.revseed.model.Override> pager = overrideRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            List<Integer> parentList = new ArrayList<Integer>();
            parentList.add(clientId);
            if (clientId != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                        		// root.get("clientId").in(parentList)));
                                criteriaBuilder.equal(
                                        root.get("clientId"), clientId.toString())));
            }
            
            if (status != null && !status.equals("")) {
            	
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("activeOverride"),status)));
            }
            if (startOverrideDateTime != null) { predicatesList.add( criteriaBuilder.and(
			  criteriaBuilder.greaterThanOrEqualTo( root.get("overridenDate").as(Date.class),startOverrideDateTime)));
			} 
            
            if (endOverrideDateTime != null) { predicatesList.add( criteriaBuilder.and(
			  criteriaBuilder.lessThanOrEqualTo( root.get("overridenDate").as(Date.class),endOverrideDateTime))); 
			}
            
            if (startCheckinDateTime != null) { 
            	predicatesList.add( 
            			criteriaBuilder.and(
            					criteriaBuilder.greaterThanOrEqualTo( 
            							root.get("checkinDate").as(Date.class),startCheckinDateTime)));
  			} 
              
              if (endCheckinDateTime != null) { 
            	  predicatesList.add( 
            			  criteriaBuilder.and(
            					  criteriaBuilder.lessThanOrEqualTo( 
            							  root.get("checkinDate").as(Date.class),endCheckinDateTime))); 
  			}
			 

            if (algo != null && !algo.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("overrideAlgo"), algo)));
            }
            
            if (algo != null && !algo.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("overrideAlgo"), algo)));
            }
            
            if (overriddenBy != null && overriddenBy.size()>0) {
            	predicatesList.add(
                        criteriaBuilder.and(
                                        root.get("overridenBy").in(overriddenBy)));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, page);
		
    return pager;
	}


	@Override
	public Page<UILayout> findUILayoutByConditions(Integer pagenum, Integer pagesize, String name, String status,
			Pageable pageable) {
		 Page<UILayout> pager = uiLayoutRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
	            List<Predicate> predicatesList = new ArrayList<>();
	            if (status != null && !status.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                        root.get("status"), status )));
	            }
	            if (name != null && !name.equals("")) {
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                        root.get("name"),"%"+name+"%")));
	            }
	            return criteriaBuilder.and(
	                    predicatesList.toArray(new Predicate[predicatesList.size()]));
	        }, pageable);
	    return pager;
	}


	@Override
	public Page<Permissions> findPermissionsByConditions(Integer pagenum, Integer pagesize, String roleCustom,
			Boolean isEditable, Integer accountId, Integer clientId, String status,Boolean isPredefined, String name,String type, Pageable pageable) throws Exception{
		Page<Permissions> pager = permissionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (roleCustom != null && !roleCustom.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("roleCustom"),roleCustom)));
            }
            if (isEditable != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("isEditable"),isEditable)));
            }
            if ((name != null && !name.equals("")) || (type != null && !type.equals(""))) {
            	Join<Permissions, UILayout> uilayout = root.join("uiLayoutId");
	            if (name != null && !name.equals("")) {            	
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.like(
	                                		uilayout.get("name"),"%"+name+"%")));
	            }	            
	            if (type != null && !type.equals("")) {            	
	                predicatesList.add(
	                        criteriaBuilder.and(
	                                criteriaBuilder.equal(
	                                		uilayout.get("layoutType"),type)));
	            }
            }
            if (accountId != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("accountId"),accountId)));
            }

            if (clientId != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("clientId"),clientId)));
            }
            
            if (isPredefined != null) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("isPredefined"),isPredefined)));
            }

            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}


	@Override
	public Page<Permissions> findPermissionsReportByConditions(Integer pagenum, Integer pagesize, String roleCustom,
			Integer accountId, String status, Pageable pageable) {
		Page<Permissions> pager = permissionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            Predicate exp1 = null;
            Predicate exp2 = null;
            Predicate exp3 = null;
            Predicate or = null;
            Predicate and = null;
            if (status != null && !status.equals("")) {
                exp1 = criteriaBuilder.equal(root.get("status"), status);
            }
            if (roleCustom != null && !roleCustom.equals("")) {
                exp2 = criteriaBuilder.equal(root.get("roleCustom"), roleCustom);
            }
            if (accountId != null) {
                exp3 = criteriaBuilder.equal(root.get("accountId"), accountId);
            }
            if(exp2!=null && exp3!=null) {
            	or = criteriaBuilder.or(exp2, exp3);
            }else if (exp2==null && exp3!=null) {
            	or = exp3;
            }else if (exp2!=null && exp3==null) {
            	or = exp2;
            }
            if(exp1!=null && or!=null) {
	            and = criteriaBuilder.and(exp1, or);
	            predicatesList.add(and);
            }else if (exp1!=null && or==null) {
	            and = exp1;
	            predicatesList.add(and);
            }else if (exp1==null && or!=null) {
	            and = or;
	            predicatesList.add(and);
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;

	}


	@Override
	public Page<CountryStateCity> findCountryStateCityByConditions(Integer pagenum, Integer pagesize, String name,
			String type, String status, Pageable pageable) {
		Page<CountryStateCity> pager = countryStateCityRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (type != null && !type.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("type"), type )));
            }
            if (name != null && !name.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("name"),"%"+name+"%")));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}


	@Override
	public Page<RoomTypes> findRoomTypesByConditions(Integer pagenum, Integer pagesize, String name, String status,
			Pageable pageable) {
		Page<RoomTypes> pager = roomTypesRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (name != null && !name.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("name"),"%"+name+"%")));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}

	
	@Override
	public Page<Otas> findOTAByConditions(Integer pagenum, Integer pagesize, String name, String domainName,
			String status, Pageable pageable) {
		Page<Otas> pager = otasRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (name != null && !name.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("name"),"%"+name+"%")));
            }
            if (domainName != null && !domainName.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("domainName"),"%"+domainName+"%")));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}


	@Override
	public Page<BookingStatusMapping> findBookingStatusMapList(Integer pagenum, Integer pagesize, String bookingstatus,
			String channel, String status, Pageable pageable) {
		Page<BookingStatusMapping> pager = bookingStatusMappingRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (bookingstatus != null && !bookingstatus.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("bookingStatus"),"%"+bookingstatus+"%")));
            }
            if (channel != null && !channel.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("channelManager"),channel)));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}
	
	
	@Override
	public Page<OtaMappings> findOtaMappingByConditions(Integer pagenum, Integer pagesize, String clientOta, String type,
			Integer otaId,Integer clientId,String unmappedOTAs, Pageable pageable) {
		
		Page<OtaMappings> pager = otaMappingsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (clientOta != null && !clientOta.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("clientOta"), "%"+clientOta+"%" )));
            }
            if (type != null && !type.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("type"),"%"+type+"%")));
            }
            if (clientId != null && !clientId.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("clientId"),clientId)));
            }
            if (otaId != null && !otaId.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("otaId"),otaId)));
            }
            if (unmappedOTAs != null && !unmappedOTAs.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.isNull(root.get("otaId"))));
            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;
	}
	
	

}

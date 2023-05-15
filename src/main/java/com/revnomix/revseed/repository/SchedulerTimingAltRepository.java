package com.revnomix.revseed.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revnomix.revseed.model.SchedulerTimingAlt;

public interface SchedulerTimingAltRepository extends JpaRepository<SchedulerTimingAlt,Integer>{

	public List<SchedulerTimingAlt> findAllByClientId(Long clientId);
	public List<SchedulerTimingAlt> findAllBySchedulerName(String schedulerName);
	public List<SchedulerTimingAlt> findAllByClientIdAndSchedulerName(Long clientId,String schedulerName);
	@Query(nativeQuery = true ,value = "SELECT st.* FROM revseed.scheduler_timing_alt st \n"
			+ "join clients c on c.id = st.client_id \n"
			+ "WHERE ((st.timing between :startTime AND :endTime) AND st.timing is not null AND st.is_run_today =false) AND st.scheduler_name=:schedulerName AND c.status=:status")
	public List<SchedulerTimingAlt> findAllbyTimingRec(String startTime, String endTime,String status,String schedulerName);
	
	@Query(nativeQuery = true ,value = "SELECT st.* FROM revseed.scheduler_timing_alt st \n"
			+ "join clients c on c.id = st.client_id \n"
			+ "WHERE ((st.timing between :startTime AND :endTime) AND st.timing is not null) AND st.scheduler_name=:schedulerName AND c.status=:status")
	public List<SchedulerTimingAlt> findAllbyTimingData(String startTime, String endTime,String status,String schedulerName);

	@Query(nativeQuery = true ,value = "SELECT MAX(timing) FROM revseed.scheduler_timing_alt WHERE scheduler_name=:schedulerName")
	public Time findMaxCaliberationTiming(String schedulerName);

	public Optional<SchedulerTimingAlt> findAllById(Long id);
}

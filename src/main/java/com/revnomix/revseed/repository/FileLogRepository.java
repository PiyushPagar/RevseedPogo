package com.revnomix.revseed.repository;

import java.util.List;

import org.hibernate.annotations.OrderBy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnomix.revseed.model.FileLogs;

@Repository()
public interface FileLogRepository extends JpaRepository<FileLogs,Integer>{

	FileLogs findOneById (Integer clientId);
	List<FileLogs> findAllByStatusAndIdIn (String status, List<Integer> id);
	List<FileLogs> findByStatus(String status);
	List<FileLogs> findByClientId(Integer clientId);
	List<FileLogs> findByClientIdAndType(Integer clientId,String type, Sort sort);
	//List<FileLogs> findByClientIdAndTypeOrderByuploaddateDesc(Integer clientId);
	

}


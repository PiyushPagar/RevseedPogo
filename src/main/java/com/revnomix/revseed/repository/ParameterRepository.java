package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("parameterRepository")
public interface ParameterRepository extends JpaRepository<Parameter,Integer>{
    List<Parameter> findAllByClientId(Integer clientId);
    Optional<Parameter> findByClientIdAndParamName(Integer clientId, String para);
}

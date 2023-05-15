package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("locationsRepository")
public interface LocationsRepository extends JpaRepository<Locations,Integer> {
    List<Locations> findByNameContainingAndTypeAndParent(String keywords, String type, Integer parent);

    List<Locations> findByNameContainingAndType(String keywords, String type);

    List<Locations> findByNameStartingWithAndTypeAndParent(String keywords, String city, Integer state);

    List<Locations> findByNameStartingWithAndType(String keywords, String city);
}

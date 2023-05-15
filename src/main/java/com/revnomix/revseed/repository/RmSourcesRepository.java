package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.RmSources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmSourcesRepository extends JpaRepository<RmSources, Integer> {
    RmSources findOneByWebsiteCode(Integer websiteCode);
}

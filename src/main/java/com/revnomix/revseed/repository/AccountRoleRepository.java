package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {

	public AccountRole findByRoleCode(String authority);
}

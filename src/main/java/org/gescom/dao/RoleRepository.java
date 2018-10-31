package org.gescom.dao;

import org.gescom.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
	
	public AppRole findByRoleName(String roleName);   
}

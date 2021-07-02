package com.example.tdfin.repository;

import com.example.tdfin.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);

}

package com.example.tdfin.repository;

import com.example.tdfin.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
public AppUser findByUsername(String username);
}

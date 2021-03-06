package com.example.tdfin.services;


import com.example.tdfin.entities.AppRole;
import com.example.tdfin.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
}

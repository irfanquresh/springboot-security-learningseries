package com.intellocent.springboot.dao;

import com.intellocent.springboot.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}

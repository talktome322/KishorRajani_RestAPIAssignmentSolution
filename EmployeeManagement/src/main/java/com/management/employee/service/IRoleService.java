package com.management.employee.service;

import java.util.List;

import com.management.employee.entity.Role;

public interface IRoleService {

	public Role addRole(Role role);
	public List<Role> findByRoleName(String roleName);
	public List<Role> fetchAllRoles();
}

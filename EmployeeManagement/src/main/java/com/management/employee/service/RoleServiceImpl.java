package com.management.employee.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.employee.entity.Role;
import com.management.employee.repository.IRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role addRole(Role role) throws EntityExistsException {
		
		
		List<Role> roles=findByRoleName(role.getRoleName());
		if (roles.isEmpty()) {
			return roleRepository.save(role);
		}
		else
			throw new EntityExistsException("Role Already Exists!");
	}
	
	@Override
	public List<Role> findByRoleName(String roleName) {
		return roleRepository.findRoleByRoleName(roleName);
	}

	@Override
	public List<Role> fetchAllRoles() {
		return roleRepository.fetchAllRoles();
	}
}

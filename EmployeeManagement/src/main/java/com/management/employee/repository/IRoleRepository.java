package com.management.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
	
	@Query ("select r from Role r where r.roleName=?1")
	public List<Role> findRoleByRoleName (String roleName);
	
	@Query ("select r from Role r")
	public List<Role> fetchAllRoles ();
}

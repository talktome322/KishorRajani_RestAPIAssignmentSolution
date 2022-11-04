package com.management.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.Role;
import com.management.employee.service.IRoleService;

@RestController
@RequestMapping ("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@PostMapping ("/add")
	public Role addRole(@RequestParam ("roleName") String roleName) {
		Role role=new Role(roleName);
		return roleService.addRole(role);
	}

}

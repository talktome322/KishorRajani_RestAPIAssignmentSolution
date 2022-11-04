package com.management.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.User;
import com.management.employee.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@PostMapping ("/add")
	public User add(@RequestBody User user) {
		System.out.println("User added "+ user.getUsername());
		return userDetailsServiceImpl.addUser(user);
	}
}

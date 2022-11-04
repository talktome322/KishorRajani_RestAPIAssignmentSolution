package com.management.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.employee.entity.Role;
import com.management.employee.entity.User;
import com.management.employee.repository.IUserRepository;
import com.management.employee.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.getUserByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		else
			return new UserDetailsImpl(user);	
	}

	//This method checks if the role passed as argument in user, already exists in roles table in database
	//If role is found, then same role id is assigned to the added user
	//If role is not found, it is added to database using rolesService
	public User addUser(User user) {
		List<Role> roles=roleService.fetchAllRoles();

		List<Role> userRoles = user.getRoles();
		for (Role userRole : userRoles) {
			boolean userRoleFound = false;
			for (Role role : roles) {
				if(role.getRoleName().equals(userRole.getRoleName())) {
					userRole.setId(role.getId());
					userRoleFound=true;
				}	
			}
			if(!userRoleFound) {
				roleService.addRole(userRole);
			}
		}
		user.setRoles(userRoles);
		return userRepository.save(user);
	}
}

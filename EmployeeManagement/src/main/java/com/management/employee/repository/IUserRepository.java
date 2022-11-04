package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	@Query ("select u from User u where u.username=?1")
	public User getUserByUsername(String username);
}

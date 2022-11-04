package com.management.employee.service;

import java.util.List;


import com.management.employee.entity.Employee;

import org.springframework.data.domain.Sort;

public interface IEmployeeService {

	public Employee addEmployee(Employee employee);
	public List<Employee> displayAllEmployees();
	public Employee findEmployeeById (int employeeId);
	public List<Employee> findEmployeeByFirstName (String firstName);
	public boolean deleteEmployee(int employeeId);
	public boolean updateEmployee(int employeeId, String firstName, String lastName, String email);
	public List<Employee> sortEmployees(Sort sortingOrder);	
}

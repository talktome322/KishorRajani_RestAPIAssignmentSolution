package com.management.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.employee.entity.Employee;
import com.management.employee.repository.IEmployeeRepository;

import org.springframework.data.domain.Sort;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> displayAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		}	
		else
			return null;
	}

	@Override
	public List<Employee> findEmployeeByFirstName(String firstName) {
		return employeeRepository.getEmployeeByFirstName(firstName);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee=findEmployeeById(employeeId);
		if (employee!=null) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateEmployee(int employeeId, String firstName, String lastName, String email) {
		Employee employee=findEmployeeById(employeeId);
		if (employee!=null) {
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employeeRepository.save(employee);
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Employee> sortEmployees(Sort sortingOrder) {
		return employeeRepository.findAll(sortingOrder);
	}

}

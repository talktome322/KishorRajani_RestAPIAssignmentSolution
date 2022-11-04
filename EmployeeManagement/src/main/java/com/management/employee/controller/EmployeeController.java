package com.management.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.management.employee.entity.Employee;
import com.management.employee.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping ("/add")
	public Employee add(@RequestParam ("firstName") String firstName,
			@RequestParam ("lastName") String lastName,
			@RequestParam ("email") String email) {
		Employee employee = new Employee(firstName, lastName, email);
		System.out.println("Employee added "+ employee.getFirstName());
		return employeeService.addEmployee(employee);
	}

	@GetMapping ("/show-employees")
	public List<Employee> listEmployees(){
		return employeeService.displayAllEmployees();
	}

	@GetMapping ("/search-emp/{id}")
	public Employee search(@PathVariable ("id") Integer employeeId) {
		return employeeService.findEmployeeById(employeeId);	
	}

	@PutMapping ("/update")
	public boolean update(@RequestParam ("id") Integer id,
			@RequestParam ("firstName") String firstName, 
			@RequestParam ("lastName") String lastName,
			@RequestParam ("email") String email) {	
		return employeeService.updateEmployee(id, firstName, lastName, email);	
	}

	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable ("id") Integer employeeId) {
		boolean empStatus=employeeService.deleteEmployee(employeeId);
		if (empStatus==true) {
			return new ResponseEntity<String>("Deleted employee id - "+employeeId,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Employee "+employeeId+" not found!",HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping ("/search/{firstName}")
	public List<Employee> searchByName(@PathVariable ("firstName") String firstName) {
		return employeeService.findEmployeeByFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> getSortedEmployee(@RequestParam("order") String sortDir)
	{
		Sort sortingOrder = sortDir.equals("asc") ? Sort.by("firstName").ascending() : Sort.by("firstName").descending();
		return employeeService.sortEmployees(sortingOrder);
	}

}

package com.ihub.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.www.EmployeeService;
import com.ihub.www.model.EmployeeModel;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	@Autowired
   EmployeeService employeeService;
	
	@GetMapping("/fetch") 
	public List<EmployeeModel> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/fetch")
	public EmployeeModel createEmployee(@RequestBody EmployeeModel employee)
	{
		return  employeeService.createEmployee(employee);
	}
	
	@GetMapping("/fetch/{id}")
	public EmployeeModel getEmployeeById(@PathVariable Long id )
	{
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/fetch/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id ,@RequestBody EmployeeModel employee)
	{
		return employeeService.updateEmployee(id,employee);
	}
	
    @DeleteMapping("/fetch/{id}")
		public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id)
	{
		return employeeService.deleteEmployee(id);
	}
	
   
} 

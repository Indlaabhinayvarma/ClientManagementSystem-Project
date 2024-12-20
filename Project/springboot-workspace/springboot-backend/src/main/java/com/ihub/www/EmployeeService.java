package com.ihub.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ihub.www.exception.ResourceNotFoundException;
import com.ihub.www.model.EmployeeModel;
import com.ihub.www.repository.EmployeeRepository;


@Service
public class EmployeeService  
{
	@Autowired
    EmployeeRepository employeeRepository; 
	
	public List<EmployeeModel> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public EmployeeModel createEmployee(EmployeeModel employee)
	{
		return employeeRepository.save(employee);
	}
	
	public EmployeeModel getEmployeeById(Long id)
	{
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
	}
	
	public ResponseEntity<EmployeeModel> updateEmployee( Long id , EmployeeModel employee)
	{
		EmployeeModel emp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
		
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		
		EmployeeModel updateEmp=employeeRepository.save(emp);
		
		return ResponseEntity.ok(updateEmp);
		
	}
	
	

	public ResponseEntity<HttpStatus> deleteEmployee(Long id)
	{
		EmployeeModel deleteEmp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID Does not exist"));
		
		  employeeRepository.delete(deleteEmp);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

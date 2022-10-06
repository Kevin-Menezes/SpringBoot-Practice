package com.csa.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.csa.entities.Employee;
import com.csa.payloads.EmployeeRequest;
import com.csa.payloads.MessageResponse;
import java.util.List;

@Component
public interface EmployeeService {
	
	public MessageResponse createEmployee(EmployeeRequest er);
	
	public MessageResponse updateEmployee(Integer empId,EmployeeRequest er);
	
	public void deleteEmployee(Integer empId);
	
	public Employee getSingleEmployee(Integer empId);
	
	public List<Employee> getAllEmployee();

}

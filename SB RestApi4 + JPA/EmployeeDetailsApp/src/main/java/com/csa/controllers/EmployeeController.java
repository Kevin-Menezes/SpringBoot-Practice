package com.csa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csa.entities.Employee;
import com.csa.payloads.EmployeeRequest;
import com.csa.payloads.MessageResponse;
import com.csa.service.EmployeeService;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService eser;
	
	// Create
	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest er){
		MessageResponse msg = eser.createEmployee(er);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<MessageResponse> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeRequest er){
		MessageResponse msg = eser.updateEmployee(id,er);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id){
		eser.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// ReadAll
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> fetchAllEmployees (){
		List<Employee> list = eser.getAllEmployee();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	// ReadOne
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> fetchEmployeeById(@PathVariable Integer id){
		Employee emp = eser.getSingleEmployee(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
}

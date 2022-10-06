package com.csa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csa.dao.EmployeeDAO;
import com.csa.entities.Employee;
import com.csa.exception.ResourceNotFoundException;
import com.csa.payloads.EmployeeRequest;
import com.csa.payloads.MessageResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO edao;

	@Override
	public MessageResponse createEmployee(EmployeeRequest er) throws ResourceNotFoundException{
		Employee emp = new Employee();
		emp.setFirstName(er.getFirstName());
        emp.setLastname(er.getLastname());
        emp.setPhoneNumber(er.getPhoneNumber());
        emp.setEmail(er.getEmail());
        emp.setSalary(er.getSalary());
        emp.setDepartment(er.getDepartment());
        
        edao.save(emp);
		return new MessageResponse("New Employee Added!");
	}

	@Override
	public MessageResponse updateEmployee(Integer empId, EmployeeRequest er) throws ResourceNotFoundException{
		Optional<Employee> employee = edao.findById(empId);
		if (employee.isEmpty()){
	        throw new ResourceNotFoundException("Employee", "id", empId);
        }
        else
        employee.get().setFirstName(er.getFirstName());
        employee.get().setLastname(er.getLastname());
        employee.get().setPhoneNumber(er.getPhoneNumber());
        employee.get().setEmail(er.getEmail());
        employee.get().setSalary(er.getSalary());
        employee.get().setDepartment(er.getDepartment());
        
        edao.save(employee.get());
        return new MessageResponse("Employee Updated!");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteEmployee(Integer empId) throws ResourceNotFoundException{
		
		if(edao.getById(empId).getId().equals(empId)) {
			edao.deleteById(empId);
		}
		else throw new ResourceNotFoundException("Employee", "id", empId);
    
	}

	@Override
	public Employee getSingleEmployee(Integer empId) {
		
		return edao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return edao.findAll();
	}

}

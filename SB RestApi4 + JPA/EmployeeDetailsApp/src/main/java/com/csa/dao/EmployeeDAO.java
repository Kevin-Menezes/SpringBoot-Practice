package com.csa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csa.entities.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}

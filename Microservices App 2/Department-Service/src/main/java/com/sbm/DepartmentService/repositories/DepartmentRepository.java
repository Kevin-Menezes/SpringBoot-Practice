package com.sbm.DepartmentService.repositories;

import com.sbm.DepartmentService.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentId(Long departmentId);
}

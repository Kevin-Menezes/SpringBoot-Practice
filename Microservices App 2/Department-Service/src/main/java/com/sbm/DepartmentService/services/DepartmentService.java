package com.sbm.DepartmentService.services;

import com.sbm.DepartmentService.entities.Department;
import com.sbm.DepartmentService.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository dr;

    public Department saveDepartment(Department department){
        return dr.save(department);
    }

    public Department findDepartment(Long departmentId){
        return dr.findByDepartmentId(departmentId);
    }
}

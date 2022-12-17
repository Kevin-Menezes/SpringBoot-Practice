package com.sbm.DepartmentService.controllers;

import com.sbm.DepartmentService.entities.Department;
import com.sbm.DepartmentService.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService ds;

    // Save a department details
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return ds.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department findDepartment(@PathVariable("departmentId") Long departmentId){
        return ds.findDepartment(departmentId);
    }

}

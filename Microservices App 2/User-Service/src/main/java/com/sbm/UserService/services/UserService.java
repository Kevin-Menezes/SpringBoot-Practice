package com.sbm.UserService.services;

import com.sbm.UserService.UserServiceApplication;
import com.sbm.UserService.controllers.UserController;
import com.sbm.UserService.entities.Department;
import com.sbm.UserService.entities.ResponseTemplate;
import com.sbm.UserService.entities.Users;
import com.sbm.UserService.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private RestTemplate restTemplate;



    public Users saveUser(Users users) {

        return ur.save(users);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {

        ResponseTemplate rt = new ResponseTemplate();
        Users users = ur.findByUserId(userId);

        // Getting the department details from the Department microservice
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + users.getDepartmentId(), Department.class);

        rt.setUsers(users);
        rt.setDepartment(department);
        return rt;
    }
}

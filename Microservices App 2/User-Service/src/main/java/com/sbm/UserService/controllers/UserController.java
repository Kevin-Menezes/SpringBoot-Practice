package com.sbm.UserService.controllers;

import com.sbm.UserService.UserServiceApplication;
import com.sbm.UserService.entities.ResponseTemplate;
import com.sbm.UserService.entities.Users;
import com.sbm.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users users){

        return us.saveUser(users);
    }

    @GetMapping("/{userId}")
    //@CircuitBreaker(name="UserWithDepartment", fallbackMethod = "userServiceFallback")
    public ResponseTemplate getUserWithDepartment(@PathVariable("userId") Long userId){

        return us.getUserWithDepartment(userId);

    }

    // Fallback method for user service
    public String userServiceFallback(Exception e){
        return "Issue in User Service! Please try after sometime!";
    }

}

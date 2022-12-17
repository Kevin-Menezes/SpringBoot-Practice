package com.sbm.APIGateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallbackMethod(){
        return "User Service is not responding! Please try later!";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallbackMethod(){
        return "Department Service is not responding! Please try later!";
    }

}

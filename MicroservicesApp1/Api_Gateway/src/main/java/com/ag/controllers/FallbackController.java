package com.ag.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FallbackController {
	
	@RequestMapping(value = "/")
	@HystrixCommand(fallbackMethod = "userServiceFallback", commandProperties = {
	   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
	})
	
	@GetMapping("/UserServiceFallback")
	public String userServiceFallback() {
		return "User service is down!";
	}

	@GetMapping("/ContactServiceFallback")
	public String contactServiceFallback() {
		return "Contact service is down!";
	}
	
	
}

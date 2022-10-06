package com.sbrs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbrs.entities.Course;
import com.sbrs.dao.CourseDAO;

@RestController
public class TestController {
	
	@Autowired
	private CourseDAO cdao;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to the Kevin's Courses";
	}
	
	// ========== Get all courses =============
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return cdao.findAll();
	}
	
	// ========== Get 1 course by id =============
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable("courseId") Long courseId) {
		return cdao.findById(courseId);
	}

	// ========== Insert 1 course =============
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		cdao.save(course);
		return course;
	}
	
	// ========== Update 1 course =============
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		cdao.save(course);
		return course;
	}
	
	// ========== Delete 1 course =============
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") Long courseId){
		
		try {
			Course c = cdao.getReferenceById(courseId);
			cdao.delete(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
	}	
	
}

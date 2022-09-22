package com.sbr.controller;

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

import java.util.List;

import com.sbr.dao.CourseDAO;
import com.sbr.entities.Course;

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
		
		return cdao.getAllCourses();
	}

	// ========== Get 1 course by id =============
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return cdao.getCourseById(Long.parseLong(courseId));
	}
	
	// ========== Insert 1 course =============
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return cdao.addNewCourse(course);
	}
	
	// ========== Update 1 course =============
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return cdao.updateExistingCourse(course);
	}
	
	// ========== Delete 1 course =============
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		
		try {
			cdao.deleteExistingCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

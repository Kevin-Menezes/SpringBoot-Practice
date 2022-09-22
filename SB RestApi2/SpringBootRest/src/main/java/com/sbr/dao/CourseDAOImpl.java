package com.sbr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sbr.entities.Course;

@Service
public class CourseDAOImpl implements CourseDAO{

	List<Course> list;
	
	// ==================== Creating a static list
	public CourseDAOImpl() {
		list = new ArrayList<>();
		
		list.add(new Course(1,"JAVA","Introduction to JAVA"));
		list.add(new Course(2,"PYTHON","Introduction to PYTHON"));
		list.add(new Course(3,"HTML","Introduction to HTML"));
		list.add(new Course(4,"GOLANG","Introduction to GOLANG"));
	}
	
	// ==================== Get all courses
	@Override
	public List<Course> getAllCourses() {
		
		return list;
	}

	// =================== Get single course by id
	@Override
	public Course getCourseById(long cid) {
		
		Course c = null;
		for(Course course:list) {
			if(course.getId()==cid) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	
	// =========== Add a new course
	@Override
	public Course addNewCourse(Course course) {
		list.add(course);
		return course;
	}

	
	// =========== Update existing course
	@Override
	public Course updateExistingCourse(Course course) {
		
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		
		return course;
	}

	// =========== Delete existing course
	@Override
	public void deleteExistingCourse(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
	
	
	
	

}

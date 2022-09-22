package com.sbr.dao;

import java.util.List;

import com.sbr.entities.Course;

public interface CourseDAO {
	
	public List<Course> getAllCourses();
	
	public Course getCourseById(long cid);
	
	public Course addNewCourse(Course course);
	
	public Course updateExistingCourse(Course course);
	
	public void deleteExistingCourse(long parseLong);

}

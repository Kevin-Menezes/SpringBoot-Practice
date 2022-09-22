package com.sbrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbrs.entities.Course;

public interface CourseDAO extends JpaRepository<Course, Long>{

}

package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Courses;

@Remote
public interface CoursesService {
        public String addCourses(Courses course);
        public List<Courses> viewCourses();
		/*
		 * public String deleteCourse(String coursecode);
		 */ 
        public List<String> getAllCourseCodes();
        
}

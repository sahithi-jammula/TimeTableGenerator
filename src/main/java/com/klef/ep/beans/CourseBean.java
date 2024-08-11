package com.klef.ep.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import com.klef.ep.models.Courses;
import com.klef.ep.services.CoursesService;

@ManagedBean(name="coursebean",eager=true)
public class CourseBean {
	@EJB(lookup="java:global/TimeTableGenerator/CoursesServiceImpl!com.klef.ep.services.CoursesService")
	CoursesService courseService;
	 private String coursecode;
     private String coursename;
     private String coursetype;
     private String coursedept;
     
     private List<Courses> courselist;
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getCoursename() {
		
		
		
		
		
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public String getCoursedept() {
		return coursedept;
	}
	public void setCoursedept(String coursedept) {
		this.coursedept = coursedept;
	}
	public String add() {
		Courses c=new Courses();
		c.setCoursecode(coursecode);
		c.setCoursename(coursename);
		c.setCoursetype(coursetype);
		c.setCoursedept(coursedept);
		
		courseService.addCourses(c);
		return "addcoursesform.jsf?facfs-redirect=true";
		
	}
	public List<Courses> getCourselist() {
		
		return courseService.viewCourses();
	}
	public void setCourselist(List<Courses> courselist) {
		this.courselist = courselist;
	}
	/*
	 * public String deletecourse(String cid) { courseService.deleteCourse(cid);
	 * return "viewallcourse.jsf"; }
	 */
	
	
	
	
}

package com.klef.ep.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

import com.klef.ep.models.Courses;
import com.klef.ep.models.Faculty;
import com.klef.ep.models.MapCourse;
import com.klef.ep.services.MapCourseService;

@ManagedBean(name = "mapcoursebean")
public class MapCourseBean {
	@EJB(lookup="java:global/TimeTableGenerator/MapCourseServiceImpl!com.klef.ep.services.MapCourseService")
	MapCourseService mapservice;
      private String coursecode;
      private int facultyid;
      private String component;
      private int section;
      private List<Courses> courseList;
      private List<Faculty> facultyList;
      
      private List<MapCourse> mapcourseList;
      
      
     public List<MapCourse> getMapcourseList() {
		return mapservice.viewallmapcourses();
	}
	public void setMapcourseList(List<MapCourse> mapcourseList) {
		this.mapcourseList = mapcourseList;
	}
	public MapCourseBean() {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
          EntityManager em = emf.createEntityManager();

          Query courseQuery = em.createQuery("SELECT c FROM Courses c");
          courseList = courseQuery.getResultList();

          Query facultyQuery = em.createQuery("SELECT f FROM Faculty f");
          facultyList = facultyQuery.getResultList();

          em.close();
          emf.close();
      }
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public int getFacultyid() {
		return facultyid;
	}
	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}


	public String mapCourse() {
		MapCourse m=new MapCourse();
		m.setCoursecode(coursecode);
		m.setFacultyid(facultyid);
		m.setComponent(component);
		m.setSection(section);
		
		mapservice.mapcoursetofaculty(m);
		return "mapcourses.jsf?facfs-redirect=true";
		
		
	}
	public String delete() {
		mapservice.deletemappedcourse(facultyid);
		return "viewallmappedcourses.jsf";
	}
	public List<Courses> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}
	public List<Faculty> getFacultyList() {
		return facultyList;
	}
	public void setFacultyList(List<Faculty> facultyList) {
		this.facultyList = facultyList;
	}
}

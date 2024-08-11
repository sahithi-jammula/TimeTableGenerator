package com.klef.ep.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "timetable")
public class TimeTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "facultyId", nullable = false)
    private int facultyId;

    @Column(name = "courseCode", length = 10, nullable = false)
    private String courseCode;

    @Column(name = "day", length = 10, nullable = false)
    private String day;

    @Column(name = "timeSlot", length = 20, nullable = false)
    private String timeSlot;
    
    
  


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getFacultyId() {
		return facultyId;
	}


	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getTimeSlot() {
		return timeSlot;
	}


	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}


	
	
    
}
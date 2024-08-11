package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.MapCourse;

@Remote
public interface MapCourseService {
      public String mapcoursetofaculty(MapCourse mapcourse);
      public List<MapCourse> viewallmapcourses();
      public String deletemappedcourse(int facultyid);
	  public List<MapCourse> viewMappedCoursesByFacultyId(int id);

}

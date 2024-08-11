package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.TimeTable;

@Remote
public interface FacultyService {
	
	  public String addfaculty(Faculty faculty);//registration
	  public String updatefaculty(Faculty faculty);
	  public String deletefaculty(int fid);
		public List<Faculty> viewallfaculty(); 
		public Faculty viewfacultybyid(int fid) ;

	  public List<Integer> getAllFacultyIds();

	  
	  public Faculty checkfacultylogin(String email,String password); 
      
}

package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Faculty;

@Remote
public interface AdminService {
	  public Admin checkadminlogin(String username,String password);
	  public List<Faculty> viewallemps();
	  public long coursecount();
	  public String addCourse();
	  public long facultycount();
	  public long mappedcoursecount();
}

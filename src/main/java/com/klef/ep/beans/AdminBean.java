package com.klef.ep.beans;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.klef.ep.models.Admin;
import com.klef.ep.services.AdminService;

@ManagedBean(name="adminbean", eager = true)
public class AdminBean {

  @EJB(lookup="java:global/TimeTableGenerator/AdminServiceImpl!com.klef.ep.services.AdminService")
  private AdminService adminService;

  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void validateadminlogin() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
    Admin a = adminService.checkadminlogin(username, password);

    if (a != null) {
      HttpSession session = request.getSession();
      session.setAttribute("admin", a);
      response.sendRedirect("adminhome.jsp");
    } else {
      response.sendRedirect("adminloginfail.jsf");
    }
  }

  public long getfacultycount() {
	  
	  
	  
    return adminService.facultycount();
  }
	
	 public long getcoursecount() {
	
		 return adminService.coursecount();
	 }
	 public long getmappedcoursescount() {
		 return adminService.mappedcoursecount();
	 }
}

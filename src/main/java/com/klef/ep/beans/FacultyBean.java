package com.klef.ep.beans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.MapCourse;
import com.klef.ep.services.FacultyService;
import com.klef.ep.services.MapCourseService;

@ManagedBean(name = "facultybean", eager = true)
public class FacultyBean {
    @EJB(lookup = "java:global/TimeTableGenerator/FacultyServiceImpl!com.klef.ep.services.FacultyService")
    FacultyService service;
    @EJB(lookup = "java:global/TimeTableGenerator/MapCourseServiceImpl!com.klef.ep.services.MapCourseService")
    MapCourseService mapcourseservice;

    private int id;
    private String name;
    private String gender;
    private String branch;
    private String dob;
    private String email;
    private String contact;
    private String password;
    private List<Faculty> faclist;
    private List<MapCourse> mappedCourses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String add() {
        Faculty f = new Faculty();
        f.setId(id);
        f.setName(name);
        f.setGender(gender);
        f.setBranch(branch);
        f.setDob(dob);
        f.setEmail(email);
        f.setContact(contact);
        f.setPassword(password);

        service.addfaculty(f);
        return "facultysignup.jsf?facfs-redirect=true";
    }

    public void validatelogin() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        HttpServletResponse response = (HttpServletResponse) ec.getResponse();

        Faculty f = service.checkfacultylogin(email, password);
        if (f != null) {
            HttpSession session = request.getSession();
            session.setAttribute("fac", f);
            response.sendRedirect("facultyhome.jsp");
        } else {
            response.sendRedirect("facultyloginfail.jsf");
        }
    }

    public List<Faculty> getFaclist() {
        return service.viewallfaculty();
    }

    public void setFaclist(List<Faculty> faclist) {
        this.faclist = faclist;
    }

    public String delete() {
        service.deletefaculty(id);
        return "viewallfaculty.jsf";
    }

    public List<MapCourse> getMappedCourses() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();

        HttpSession session = request.getSession();
        if (session != null) {
            Faculty f = (Faculty) session.getAttribute("fac");
            if (f != null) {
                mappedCourses = mapcourseservice.viewMappedCoursesByFacultyId(f.getId());
            }
        }

        return mappedCourses;
    }
}

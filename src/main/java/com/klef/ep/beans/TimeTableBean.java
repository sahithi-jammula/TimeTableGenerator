package com.klef.ep.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import com.klef.ep.models.TimeTable;
import com.klef.ep.models.Faculty;
import com.klef.ep.services.TimeTableService;

@ManagedBean(name = "timetableBean")
public class TimeTableBean {
    @EJB(lookup = "java:global/TimeTableGenerator/TimeTableServiceImpl!com.klef.ep.services.TimeTableService")
    TimeTableService timetableService;
    private Integer facultyId;

    private List<TimeTable> timetable;
    private List<TimeTable> allTimetables; 

    public List<TimeTable> getTimetable() {
        if (facultyId != null) {
            timetable = timetableService.getTimetableByFacultyId(facultyId);
        }
        return timetable;
    }

    public void setTimetable(List<TimeTable> timetable) {
        this.timetable = timetable;
    }

    public List<TimeTable> getAllTimetables() {
        return allTimetables;
    }

    public void setAllTimetables(List<TimeTable> allTimetables) {
        this.allTimetables = allTimetables;
    }

    public String generateTimetable() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Faculty faculty = (Faculty) session.getAttribute("fac");

        timetable = timetableService.generateTimetable(faculty.getId());

        return "viewTimetable.jsp";
    }
    public String viewTimetable() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Faculty faculty = (Faculty) session.getAttribute("fac");

        if (faculty != null) {
            timetable = timetableService.getTimetableByFacultyId(faculty.getId());
        } else {
            // Handle the case where faculty is not found in session
            timetable = new ArrayList<>();
        }

        return "viewTimetable.jsp";
    }

    

    public void generateTimetableForAllFaculty() {
        timetableService.generateTimetableForAllFaculty();
    }

    public String viewAllTimetables() {
        allTimetables = timetableService.getAllTimetables();
        return "viewAllTimetables.jsf";
    }
}
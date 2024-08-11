package com.klef.ep.services;

import com.klef.ep.models.TimeTable;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TimeTableService {
    void generateTimetableForAllFaculty();
    List<TimeTable> generateTimetable(int facultyId);
    List<TimeTable> getTimetableByFacultyId(int facultyId);
    List<TimeTable> getAllTimetables(); // New method to view all timetables
}
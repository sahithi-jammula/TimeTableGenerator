package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.klef.ep.models.MapCourse;
import com.klef.ep.models.TimeTable;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TimeTableServiceImpl implements TimeTableService {

    @Override
    public void generateTimetableForAllFaculty() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT DISTINCT m.facultyid FROM MapCourse m");
        List<Integer> facultyIds = query.getResultList();

        for (Integer facultyId : facultyIds) {
            generateTimetable(facultyId);
        }

        em.close();
        emf.close();
    }

    @Override
    public List<TimeTable> generateTimetable(int facultyId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT m FROM MapCourse m WHERE m.facultyid = :facultyId");
        query.setParameter("facultyId", facultyId);
        List<MapCourse> mappedCourses = query.getResultList();

        List<TimeTable> timetable = new ArrayList<>();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {"09:00-10:00", "10:00-11:00", "11:00-12:00", "01:00-02:00", "02:00-03:00", "03:00-04:00"};

        int courseIndex = 0;
        int totalCourses = mappedCourses.size();

        for (int dayIndex = 0; dayIndex < days.length && courseIndex < totalCourses; dayIndex++) {
            for (int timeSlotIndex = 0; timeSlotIndex < timeSlots.length && courseIndex < totalCourses; timeSlotIndex++) {
                MapCourse course = mappedCourses.get(courseIndex);
                TimeTable tt = new TimeTable();
                tt.setFacultyId(course.getFacultyid());
                tt.setCourseCode(course.getCoursecode());
                tt.setDay(days[dayIndex]);
                tt.setTimeSlot(timeSlots[timeSlotIndex]);

                timetable.add(tt);
                courseIndex++;
            }
        }

        em.close();
        emf.close();

        saveTimetable(timetable);

        return timetable;
    }

    public void saveTimetable(List<TimeTable> timetable) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Clear existing timetable for the faculty
        if (!timetable.isEmpty()) {
            int facultyId = timetable.get(0).getFacultyId();
            Query deleteQuery = em.createQuery("DELETE FROM TimeTable t WHERE t.facultyId = :facultyId");
            deleteQuery.setParameter("facultyId", facultyId);
            deleteQuery.executeUpdate();
        }

        // Persist new timetable
        for (TimeTable t : timetable) {
            em.persist(t);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Override
    public List<TimeTable> getTimetableByFacultyId(int facultyId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT t FROM TimeTable t WHERE t.facultyId = :facultyId");
        query.setParameter("facultyId", facultyId);
        List<TimeTable> timetable = query.getResultList();

        em.close();
        emf.close();

        return timetable;
    }

    // Method to view timetable for all faculty
    @Override
    public List<TimeTable> getAllTimetables() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT t FROM TimeTable t");
        List<TimeTable> timetables = query.getResultList();

        em.close();
        emf.close();

        return timetables;
    }
}
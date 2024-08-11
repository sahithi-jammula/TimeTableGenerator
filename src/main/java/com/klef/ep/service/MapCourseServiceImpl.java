package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.MapCourse;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MapCourseServiceImpl implements MapCourseService {

	@Override
	public String mapcoursetofaculty(MapCourse mapcourse) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(mapcourse); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Course mapped Successfully";
		}

	@Override
	public List<MapCourse> viewallmapcourses() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select m from MapCourse m");
		// f is an alias of faculty Class
		List<MapCourse> mapcourselist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return mapcourselist;
	}

	@Override
	public String deletemappedcourse(int facultyid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		MapCourse m = em.find(MapCourse.class, facultyid);
		em.remove(m);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Mapped Course Deleted Successfully";
		
	}
	 @Override
	    public List<MapCourse> viewMappedCoursesByFacultyId(int id) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
	        EntityManager em = emf.createEntityManager();
	        
	        Query qry = em.createQuery("SELECT m FROM MapCourse m WHERE m.facultyid = :facultyid", MapCourse.class);
	        qry.setParameter("facultyid", id);
	        List<MapCourse> mappedCourses = qry.getResultList();
	        
	        em.close();
	        emf.close();
	        
	        return mappedCourses;
	    }
}

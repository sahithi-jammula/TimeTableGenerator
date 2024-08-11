package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Courses;
import com.klef.ep.models.Faculty;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CoursesServiceImpl implements CoursesService {

	@Override
	public String addCourses(Courses course) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(course); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "addedd successfully";
	}

	

	@Override
	public List<Courses> viewCourses() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		javax.persistence.Query qry = em.createQuery("select c from Courses c");
		// e is an alias of Employee Class
		List<Courses> coulist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return coulist;
	}

	/*public String deleteCourse(String coursecode) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Courses c = em.find(Courses.class, cid);
		em.remove(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Course Deleted Successfully";
	}*/
    @Override
    public List<String> getAllCourseCodes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT c.coursecode FROM Course c");
        List<String> courseCodes = query.getResultList();
        
        em.close();
        emf.close();
        
        return courseCodes;
    }


}

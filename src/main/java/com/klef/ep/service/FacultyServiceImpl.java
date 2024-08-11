package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.TimeTable;
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FacultyServiceImpl implements FacultyService {

	@Override
	public String addfaculty(Faculty faculty) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(faculty); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "faculty Registered Successfully";
	}
	@Override
	public String updatefaculty(Faculty faculty) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Faculty f = em.find(Faculty.class, faculty.getId());
		f.setContact(faculty.getContact());
		f.setName(faculty.getName());
		f.setPassword(faculty.getPassword());
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "faculty Updated Successfully";
	}

	@Override
	public String deletefaculty(int fid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Faculty f = em.find(Faculty.class, fid);
		em.remove(f);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "faculty Deleted Successfully";
	}

	@Override
	public Faculty checkfacultylogin(String email, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();

		Query qry = em.createQuery("select f from Faculty f where f.email=? and f.password=?");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		
		Faculty fac=null;
		if(qry.getResultList().size()>0) {
			fac= (Faculty) qry.getSingleResult();
			
		}
		em.close();
		emf.close();
		return fac;
	}
	public List<Faculty> viewallfaculty() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select f from Faculty f");
		// f is an alias of faculty Class
		List<Faculty> faclist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return faclist;
	}
	@Override
	public Faculty viewfacultybyid(int fid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Faculty f = em.find(Faculty.class, fid);
		if(f==null) {
			em.close();
			emf.close();
			return null;
			
		}
		
		em.close();
		emf.close();
		
		return f;
	}
	 @Override
	    public List<Integer> getAllFacultyIds() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
	        EntityManager em = emf.createEntityManager();
	        
	        Query query = em.createQuery("SELECT f.id FROM Faculty f");
	        List<Integer> facultyIds = query.getResultList();
	        
	        em.close();
	        emf.close();
	        
	        return facultyIds;
	    }
	

}

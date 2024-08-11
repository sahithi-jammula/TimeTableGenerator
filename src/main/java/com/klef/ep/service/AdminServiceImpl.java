package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Faculty;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService {

	public Admin checkadminlogin(String username, String password) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		// a is an alias of Admin Class
		Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?");
		qry.setParameter(1, username);
		qry.setParameter(2, password);
		
        Admin admin = null;
        
        if(qry.getResultList().size()>0)
        {
        	admin = (Admin) qry.getSingleResult();
        }
		em.close();
		emf.close();
		
		return admin;
	}

	@Override
	public List<Faculty> viewallemps() {
		return null;
	}

	@Override
	public String addCourse() {
		
		return null;
	}

	@Override
	public long facultycount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Query qry=em.createQuery("select count(*) from Faculty");
		List list=qry.getResultList();
		long count=(long) list.get(0);
		return count;
	}

	@Override
	public long coursecount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Query qry=em.createQuery("select count(*) from Courses");
		List list=qry.getResultList();
		long count=(long) list.get(0);
		return count;
	}

	@Override
	public long mappedcoursecount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("timetable");
		EntityManager em = emf.createEntityManager();
		
		Query qry=em.createQuery("select count(*) from MapCourse");
		List list=qry.getResultList();
		long count=(long) list.get(0);
		return count;
	}
	

}

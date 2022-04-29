package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.demo.entity.Patient;
import com.demo.entity.Course;
import com.demo.utility.EntityManagerUtil;
@Repository
public class AssignmentDAOImpl implements AssignmentDAO {
	
	EntityManagerFactory emf=EntityManagerUtil.getFactory();
	public Course getCourse(int id,String courseName) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Course> query=em.createQuery("select c from Course c where instructor_instructor_id=:id AND course_name=:courseName",Course.class);
		
		query.setParameter("id", id);
		query.setParameter("courseName",courseName);
		List<Course> list=query.getResultList();
		
	    
		em.close();
	   return list.get(0);
	   
	}
	
	public Patient find(int aid)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Patient a=em.find(Patient.class, aid);
		em.close();  //added this
		return a;
	}
	
	public Patient add(Patient assignment)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(assignment);
		em.getTransaction().commit();
		em.close();
		return assignment;
		
	}
	public void delete(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("delete from Assignment where assignment_id=:id");
        query.setParameter("id", id);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		
		
	}
	public List<Patient> view(Course c)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Patient> query=em.createQuery("select a from Assignment a where course_cid=:id",Patient.class);
		query.setParameter("id",c.getCourseId());
		
	List<Patient> list= query.getResultList();
	
		em.close();
		return list;
		
		
	}
	
	
	
	
	


}

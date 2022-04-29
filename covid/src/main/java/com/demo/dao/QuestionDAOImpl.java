package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.demo.entity.Patient;
import com.demo.entity.Contact;
import com.demo.utility.EntityManagerUtil;
@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	
	EntityManagerFactory emf=EntityManagerUtil.getFactory();
	 public Patient getAssignment(String assignment)
	 {
		 EntityManager em = emf.createEntityManager();
		 em.getTransaction().begin();
		 TypedQuery<Patient> query=em.createQuery("Select a from Assignment a where assignment_name=:assignment",Patient.class);
		 query.setParameter("assignment", assignment);
		 List<Patient> list=query.getResultList();
		em.close();
		 return list.get(0);
	 }
	public void add(Contact question)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(question);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void delete(int id)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        Query query=em.createQuery("delete from Question where question_id=:id");
        query.setParameter("id", id);
        
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contact> view(Patient assignment)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> query=em.createQuery("select a from Question a where assignment_assignment_id=:id",Contact.class);
		query.setParameter("id",assignment.getAssignmentId());
		List<Contact> list=query.getResultList();
	
		em.close();
	
		return list;
	}

	

}

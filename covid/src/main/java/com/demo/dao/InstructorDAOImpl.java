package com.demo.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.demo.dto.UserDTO;
import com.demo.entity.User;
import com.demo.model_mapper.ModelMapperService;
import com.demo.utility.EntityManagerUtil;


@Repository
public class InstructorDAOImpl implements InstructorDAO{

	EntityManagerFactory emf = EntityManagerUtil.getFactory();

	
	public List<User> getAllInstructor()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> query=em.createQuery("from Instructor i",User.class);
		List<User> list=query.getResultList();
		em.close();
		return list;
		
	}
	
	public void save(UserDTO instructorDTO)
	{
		 User instructor=	ModelMapperService.convertDtoToInsEntity(instructorDTO);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
		em.close();
		
	}



	
	
	

}

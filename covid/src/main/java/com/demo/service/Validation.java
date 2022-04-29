package com.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.InstructorDAO;
import com.demo.dto.UserDTO;
import com.demo.entity.User;
import com.demo.exceptions.EmptyFieldException;
import com.demo.exceptions.ListNotFound;
import com.demo.model_mapper.ModelMapperService;

@Service
public class Validation {
	
	@Autowired
   InstructorDAO instructorDaoInterface;
	
	public Validation(InstructorDAO instructorDaoInterface) {
		this.instructorDaoInterface=instructorDaoInterface;
	
	}
	

	public List<User> getInstructors() 
	{
		 List<User> list=instructorDaoInterface.getAllInstructor();
		
		 return list;
	}public boolean register(UserDTO instructorDTO) 
	{
		boolean flag=true;
	
		 List<User> list=getInstructors();
        for(User i:list)
        {
        	if(i.getName().equals(instructorDTO.getName()) && i.getUsername().equals(instructorDTO.getName()))
        	{
        		
        		flag=false;
        		break;
        	}
        }
        
       
        if(flag) {
        	 User instructor=	ModelMapperService.convertDtoToInsEntity(instructorDTO);
        	instructorDaoInterface.save(instructorDTO);

        
        }
        return flag;
 
	}
	
	
	
	public int verifyUser(String username,String password) 
	{
		
		
		
	        List<User> list=instructorDaoInterface.getAllInstructor();
	     
	        for(User i:list)
	        {
	        	if(i.getUsername().equals(username) && i.getPassword().equals(password))
	        	{
	        		
	        		return i.getInstructorId();
	        		
	        	}
	        }
	    	
		
		return 0;
		
	}
	

}

package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AssignmentDAO;
import com.demo.dto.PatientDTO;
import com.demo.entity.Patient;
import com.demo.entity.Course;
import com.demo.model_mapper.ModelMapperService;
@Service
public class AssignmentService {
	
	
	
	@Autowired
	private AssignmentDAO assignmentDAOInterface;
	
	public AssignmentService(AssignmentDAO assignmentDAOInterface)
	{
		this.assignmentDAOInterface=assignmentDAOInterface;
	}
	
    
	public Course getCourses(int id,String courseName)
	{
		
		
			return assignmentDAOInterface.getCourse(id,courseName);
		
	    
	}
	public Patient addAssignments(Course c,Patient assignment)
	{
		
		assignment.setCourse(c);
		
		return assignmentDAOInterface.add(assignment);
	}
	public Patient find(int aid)
	{
		Patient a=assignmentDAOInterface.find(aid);
		return a;
	}
   
	public List<PatientDTO> viewAssignments(Course c) {
		List<Patient> list= assignmentDAOInterface.view(c);
		List<PatientDTO> list1= ModelMapperService.convertAssignmentList(list);
		return list1;
	
		
	}

	public void deleteAssignments(Course c,String assignmentName) {
		List<Patient> list=c.getAssignments();
		for(Patient a:list)
		{
			if(a.getAssignmentName().equals(assignmentName))
			{
				assignmentDAOInterface.delete(a.getAssignmentId());
			}
		}
		

	}
	

}

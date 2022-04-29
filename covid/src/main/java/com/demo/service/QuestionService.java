package com.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.QuestionDAO;
import com.demo.entity.Patient;
import com.demo.entity.Contact;
import com.demo.exceptions.AssignmentNotFound;
@Service
public class QuestionService {
	private static final Logger LOGGER = LogManager.getLogger(QuestionService.class);
	@Autowired
	private QuestionDAO questionDAOInterface;
	public QuestionService(QuestionDAO questionDAOInterface) {
		this.questionDAOInterface=questionDAOInterface;
	}
	public Patient getAssignment(String a) throws AssignmentNotFound
	{
		if(questionDAOInterface.getAssignment(a)==null)
		{
			throw new AssignmentNotFound("assignment not found");
		}
		return questionDAOInterface.getAssignment(a);
	}
	public void add(Patient assignment,Contact q)
	{
		q.setAssignment(assignment);
		questionDAOInterface.add(q);
	}
	public List<Contact> view(Patient a)
	{
		return questionDAOInterface.view(a);
		
	}
	
	public void deleteQuestion(int id)
	{
		questionDAOInterface.delete(id);
		
	}

}

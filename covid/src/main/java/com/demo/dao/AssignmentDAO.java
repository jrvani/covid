package com.demo.dao;

import java.util.List;

import com.demo.entity.Patient;
import com.demo.entity.Course;

public interface AssignmentDAO {
 
	public Course getCourse(int id,String c);
	public Patient add(Patient assignment);
	public Patient find(int aid);
	public void delete(int id);
	public List<Patient> view(Course c);

}

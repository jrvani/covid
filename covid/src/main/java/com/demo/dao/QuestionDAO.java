package com.demo.dao;

import java.util.List;

import com.demo.entity.Patient;
import com.demo.entity.Contact;

public interface QuestionDAO {
	public Patient getAssignment(String a);
	public void add(Contact a);
	public void delete(int id);
	public List<Contact> view(Patient a);

}

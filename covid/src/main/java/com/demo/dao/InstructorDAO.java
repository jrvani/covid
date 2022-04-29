package com.demo.dao;

import java.util.List;

import com.demo.dto.UserDTO;
import com.demo.entity.User;

public interface InstructorDAO {
	
	public List<User> getAllInstructor();
	public void save(UserDTO instructorDTO);

}

package com.demo.dao;

import java.util.List;

import com.demo.entity.Course;
import com.demo.entity.User;

public interface CourseDAO {
	public User find(int id);
	    public List<Course> getAll();
	    public Course findCourse(int cid);
		public void delete(int id,String courseName);
		public List<Course> view(int id);
		public void add(Course course);
	

}

package com.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CourseDAO;
import com.demo.dto.CourseDTO;
import com.demo.entity.Course;
import com.demo.exceptions.CourseNotExists;
import com.demo.exceptions.InstructorNotFound;
import com.demo.model_mapper.ModelMapperService;

@Service
public class CourseService {
	@Autowired
    private CourseDAO courseDaoInterface ;
	
	

	public CourseService(CourseDAO courseDaoInterface) {
     
		this.courseDaoInterface = courseDaoInterface;

	}


	public void addCourse(int id,Course course) throws CourseNotExists {
		
		if (course.getCourseName().isBlank()) {
			throw new CourseNotExists("course not exists");
		}
		
		
		course.setInstructor(courseDaoInterface.find(id));
		courseDaoInterface.add(course);
		

	}

	public void deleteCourse(int id, String courseName) {

		courseDaoInterface.delete(id, courseName);

	}
    public CourseDTO viewCourse(int cid)
    {
    	Course c=courseDaoInterface.findCourse(cid);
    	return ModelMapperService.convertCourseEntityToDTO(c);
    }
	public List<CourseDTO> viewAllCourse(int id) {
	
		List<Course> list = courseDaoInterface.view(id);
		return ModelMapperService.convertList(list);
	}

}

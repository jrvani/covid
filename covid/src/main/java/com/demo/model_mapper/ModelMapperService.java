package com.demo.model_mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.dto.PatientDTO;
import com.demo.dto.CourseDTO;
import com.demo.dto.UserDTO;
import com.demo.dto.ContactDTO;
import com.demo.entity.Patient;
import com.demo.entity.Course;
import com.demo.entity.User;
import com.demo.entity.Contact;

@Component
public class ModelMapperService {
	
	
	private ModelMapperService() {}
	public static User convertDtoToInsEntity(UserDTO instructorDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(instructorDto,User.class);
	}
	
	public static PatientDTO convertAssEntityToDTO(Patient a)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(a,PatientDTO.class);
	}
	public static Contact convertDtoToQuestionEntity(ContactDTO question)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(question,Contact.class);
	}
	
	
	
	
	
	public static List<PatientDTO> convertAssignmentList(List<Patient> list)
	{
		ModelMapper mapper=new ModelMapper();
		return list.stream().map(i->mapper.map(i,PatientDTO.class)).collect(Collectors.toList());
	
	}
	
	
	public static UserDTO convertEntityToDto(User i)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(i,UserDTO.class);
	}
	
	public static Patient convertDtoToAssignmentEntity(PatientDTO assignmentDto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(assignmentDto,Patient.class);
	}

}

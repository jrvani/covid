package com.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class PatientDTO {
	
    private int patientId;
	
	@NotBlank(message = "Please enter your Name")
	private String name;
	
	@NotBlank(message = "Please enter your email")
	private String email;
	private String mobile;
	String pin;
	String address;
	String covid;
}

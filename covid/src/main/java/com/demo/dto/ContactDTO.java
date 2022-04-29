package com.demo.dto;

import javax.validation.constraints.NotBlank;

public class ContactDTO {
private int contactId;
	
	@NotBlank(message = "Please enter your Name")
	private String contactname;
	
	@NotBlank(message = "Please enter your email")
	private String contactemail;
	String pin;
	String address;
	
	

}

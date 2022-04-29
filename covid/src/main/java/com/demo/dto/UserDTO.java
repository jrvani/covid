package com.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class UserDTO {
	
	private int userId;
	
	@NotBlank(message = "Please enter your Name")
	private String name;
	
	@NotBlank(message = "Please enter your email")
	private String email;
	@NotBlank(message = "Please enter your password")
	private String password;
	private String mobile;
	String pin;
	String address;
	private List<ContactDTO> contactsList=new ArrayList<>();

	
    public UserDTO()
    {
    	
    }


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<ContactDTO> getContactsList() {
		return contactsList;
	}


	public void setContactsList(List<ContactDTO> contactsList) {
		this.contactsList = contactsList;
	}


	



	
}

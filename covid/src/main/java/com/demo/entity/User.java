package com.demo.entity;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="instructor_name")
	private String name;
	@Column(name="instructor_email")
	private String email;
	@Column(name="instructor_password")
	private String password;
	@Column(name="instructor_mobile")
	private String mobile;
	@Column(name="instructor_pin")
	private String pin;
	@Column(name="instructor_address")
	private String address;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL )
	private List<Contact> contactsList;

	
   

}

package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	
	@Entity
	@Table(name="contacts")
	public class Contact {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="contact_id")
		private int contactId;
		@Column(name="instructor_name")
		private String contactname;
		
		@Column(name="instructor_pin")
		private String pin;
		@Column(name="instructor_address")
		private String address;
		
		
		@ManyToOne
		private User user;
		
		
		
		
	





		
		
		


	}



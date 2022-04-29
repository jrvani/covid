package com.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="patient")
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int patientId;
	@Column(name="instructor_name")
	private String patientname;
	@Column(name="instructor_email")
	private String patientemail;
	@Column(name="instructor_pin")
	private String patientpin;
	@Column(name="instructor_address")
	private String patientaddress;
	@Column(name="covid_status")
	private String covid;

}

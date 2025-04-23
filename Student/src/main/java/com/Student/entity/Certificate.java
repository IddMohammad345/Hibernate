package com.Student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "students_certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long certificateId;

	private String title;
	
	private String about;
	
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
}

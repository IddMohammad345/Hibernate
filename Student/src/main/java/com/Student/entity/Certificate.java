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
	
	public Long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private String link;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", title=" + title + ", about=" + about + ", link="
				+ link + ", student=" + student + "]";
	}
	
	
}

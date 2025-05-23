package com.Student.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity(name ="STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer s_id;
	@Column(name = "Student_name",length = 100,unique = true)
	private String s_name;
	@Column(name = "Student_college",length = 200,nullable = true)
	private String s_college;
	private String s_phone;
	
	public List<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
	
	private String s_fathername;
	private boolean s_active;
	@Lob
	private String about;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Certificate>certificates=new ArrayList<>();
	
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_college() {
		return s_college;
	}
	public void setS_college(String s_college) {
		this.s_college = s_college;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_fathername() {
		return s_fathername;
	}
	public void setS_fathername(String s_fathername) {
		this.s_fathername = s_fathername;
	}
	public boolean isS_active() {
		return s_active;
	}
	public void setS_active(boolean s_active) {
		this.s_active = s_active;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_college=" + s_college + ", s_phone=" + s_phone
				+ ", s_fathername=" + s_fathername + ", s_active=" + s_active + ", about=" + about + ", certificates="
				+ certificates + "]";
	}
	
	
}

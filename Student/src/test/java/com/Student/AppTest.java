package com.Student;

import com.Student.entity.Student;

import junit.framework.TestCase;


public class AppTest  extends TestCase{
	
	StudentService service=new StudentService();
	
	public void getStudentTest() {
		Student byId = service.getById(1052);
		String s_name = byId.getS_name();
		System.out.println(s_name);
	}

}

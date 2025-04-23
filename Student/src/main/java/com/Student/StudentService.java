package com.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Student.Util.SingleTonSessonFactory;
import com.Student.entity.Student;

public class StudentService {
	
	private SessionFactory factory = SingleTonSessonFactory.getSessionFactory();
	
	
	//save Student
	public void saveStudent(Student student) {
		try (Session s=factory.openSession()){//using try with resource
			Transaction transaction = s.beginTransaction();
			
			s.persist(student);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//get student
	public Student getById(Long studentid) {
		try (Session session=factory.openSession()){
			Student student = session.get(Student.class, studentid);
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

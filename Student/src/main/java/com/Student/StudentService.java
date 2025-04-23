package com.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	
	//update Operation
	public Student updateStudent(Long studentid,Student student) {
		try (Session session=factory.openSession()){
			Transaction transaction = session.beginTransaction();
			Student oldStudent = session.get(Student.class, studentid);
			
			if (oldStudent != null) {
				oldStudent.setS_name(student.getS_name());
				oldStudent.setS_fathername(student.getS_fathername());
				oldStudent.setS_phone(student.getS_phone());
				oldStudent.setS_college(student.getS_college());
				oldStudent.setS_active(student.isS_active());
				session.merge(oldStudent);
			}
			transaction.commit();
			return oldStudent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Delete Operation
	public void deleteStudent(Long StudentId) {
		
		try(Session session=factory.openSession()){
			Transaction beginTransaction = session.beginTransaction();
			Student student = session.get(Student.class, StudentId);
			if (student !=null) {
				session.remove(student);
			}
			beginTransaction.commit();
		}
		
	}
	
	//HQL(JPA)->native query
	//database independent
	
	//get all student using HQL
	public List<Student>getAllStudent(){
		try(Session session=factory.openSession()){
			String setHQL="FROM Student";
			Query<Student> query = session.createQuery(setHQL,Student.class);
			return query.list();
		}
	}
	
	
	//get student By name
	public Student getStudentByName(String name) {
		try(Session session=factory.openSession()){
			String getByName="FROM Student WHERE name = :studentName";
			Query<Student> query = session.createQuery(getByName,Student.class);
			query.setParameter("studentName", name);
			return query.uniqueResult();
		}
	}

}

package com.Student;

import java.net.Socket;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Student.Util.SingleTonSessonFactory;
import com.Student.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        
        Student student=new Student();
        student.setS_name("Ankit Sinha");
        student.setS_college("IIT kanpur");
        student.setS_active(true);
        student.setS_phone("9999999999");
        student.setS_fathername("Dk Sinnha");
        student.setAbout("This is dummy student");
        
        SessionFactory factory = SingleTonSessonFactory.getSessionFactory();
         Session session = factory.openSession();
         
         Transaction transaction=null;
         
         try {
			transaction=session.beginTransaction();
			session.persist(student);
			transaction.commit();
			System.out.println("student saved successfully..");
			
		} catch (Exception e) {
		    if (transaction !=null) {
		    	transaction.rollback();				
			}
		    e.printStackTrace();
		}finally {
			session.close();
		}
        
    }
}

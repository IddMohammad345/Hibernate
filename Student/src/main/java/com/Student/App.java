package com.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Student.Util.SingleTonSessonFactory;
import com.Student.entity.Certificate;
import com.Student.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        
        Student student=new Student();
        student.setS_name("Prakash Sinha");
        
        student.setS_college("IIT bombay");
        student.setS_active(true);
        student.setS_phone("9999999999");
        student.setS_fathername("Mukesh Sinha");
        student.setAbout("This is dummy student");
        
        Certificate certificate = new Certificate();
        certificate.setTitle("Java Certification");
        certificate.setAbout("This is java certification");
        certificate.setLink("link");
        certificate.setStudent(student);
        
        Certificate certificate1 = new Certificate();
        certificate1.setTitle("Python Certification");
        certificate1.setAbout("This is python certification");
        certificate1.setLink("link");
        certificate1.setStudent(student);
        
        student.getCertificates().add(certificate);
        student.getCertificates().add(certificate1);
        SessionFactory factory = SingleTonSessonFactory.getSessionFactory();
         Session session = factory.openSession();
         
         Transaction transaction=null;
         
         StudentService service=new StudentService();
         
         try {
			transaction=session.beginTransaction();
			
			//session.persist(student);  //this logic use to save the data or create the database into database
			//Student student3 = service.getById(1002);//this logic use to get the data from database
	    	//List<Student>students=	service.getAllStudent();//this logic use to print list of all student
		//	Student student2=service.getStudentByName("Ankit Sinha");
		//	List<Student> studentsByCollege = service.getStudentsByCollege("IIT kanpur");
			service.deleteStudent(1);
			transaction.commit();
			//System.out.println("\t\t\t....Student details....  \n"+student3);
			//students.forEach(s->System.out.println(s.getS_id()+" "+s.getS_name()+"\n----------\n"));
		//    System.out.println(student2);
		//	studentsByCollege.forEach(s->System.out.println(s.getS_id()+" "+s.getS_name()+""+s.getS_phone()+"\n=======================\n"));
			
			
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

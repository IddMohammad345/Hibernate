package com.idd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.idd.Entity.Department;
import com.idd.Entity.Employee;
import com.idd.Entity.Names;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	Department department=new Department();
    	department.setDname("CSC");
    	
        Employee emp=new Employee();
        Names name=new Names();
        name.setFname("Sai");
        name.setMname("Hira");
        name.setLname("Hyderabadia");
        
        emp.setName(name);
        emp.setSalary(50000.00);
        emp.setDepartment(department);
        
        Employee emp1=new Employee();
        Names name1=new Names();
        name.setFname("Kesor");
        name.setMname("kumar");
        name.setLname("dubay");
        
        emp.setName(name);
        emp.setSalary(59000.00);
        
        Employee emp2=new Employee();
        Names name2=new Names();
        name.setFname("Adi");
        name.setMname("Lal");
        name.setLname("thakur");
        
        
        department.getEmplist().add(emp2);
        
        emp.setName(name);
        emp.setSalary(50000.00);
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = con.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        //Logic to save data using hibernate
        //session.save(emp);
       // transaction.commit();
       // session.close();
     
        
        /*
        String qry="FROM Employee E WHERE E.name.fname= :firstName";
        Query query=session.createQuery(qry);
        query.setParameter("firstName","Raju");
        Employee employe =(Employee) query.uniqueResult();
        if (employe != null) {
			Names name1=employe.getName();
			name1.setMname("doBalowala");
			name1.setLname("DholakPur");
			employe.setName(name1);
			employe.setSalary(40000.00);
		}else {
			System.out.println("please Enter correct employee name : ...");
		}
        
        */
        
        
        
        transaction.commit();
        session.close();
        
    }
}

package com.idd;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.idd.Entity.Employee;
import com.idd.Entity.Names;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Employee emp=new Employee();
        Names name=new Names();
        name.setFname("Raju");
        name.setMname("Takle");
        name.setLname("Dholakpuriya");
        
        emp.setName(name);
        emp.setSalary(50000.00);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = con.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
       // session.save(emp);
      //  transaction.commit();
       // session.close();
        
        String qry="FROM Employee E WHERE E.name.fname= :firstName";
        Query query=session.createQuery(qry);
        query.setParameter("firstName","Raju");
        Employee employe =(Employee) query.uniqueResult();
        if (employe != null) {
			Names name1=employe.getName();
			name1.setMname("doBalwala");
			name1.setLname("DholakPur");
			employe.setName(name1);
			employe.setSalary(40000.00);
		}else {
			System.out.println("please Enter correct employee name : ...");
		}
        
        transaction.commit();
        session.close();
        
    }
}

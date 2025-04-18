package com.idd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.idd.Entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Employee emp=new Employee();
        emp.setName("raju");
        emp.setSalary(50000.00);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = con.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(emp);
        transaction.commit();
        session.close();
    }
}

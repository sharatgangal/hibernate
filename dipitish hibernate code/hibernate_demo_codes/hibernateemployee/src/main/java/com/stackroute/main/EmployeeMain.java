package com.stackroute.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.stackroute.model.Employee;



public class EmployeeMain {

	public static void main(String str[])
	{
Configuration configuration = new Configuration();
		
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		 Session session=sessionFactory.openSession();
	     Transaction transaction=session.beginTransaction();
	  	Employee employee=new Employee();
	  	employee.setFirstName("John");
	  	employee.setLastName("Mathews");
	  	employee.setSalary(24000);
	
	  	  session.save(employee);
        transaction.commit(); 
        session.close();	
	}
}

package com.stackroute.hibernatedemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.stackroute.demos.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		 Session session=sessionFactory.openSession();
	     Transaction transaction=session.beginTransaction();
	  	 Employee employee=new Employee();
	     employee.setId(1);
	     employee.setName("Akash");
	     employee.setBasic(10000);
	  	  session.save(employee);
        transaction.commit(); 
        session.close();
	}

}

package com.stackroute.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.stackroute.model.Customer;

public class CustomerMain {

	public static void main(String[] args) {
	Configuration configuration = new Configuration();
		
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		 Session session=sessionFactory.openSession();
	     Transaction transaction=session.beginTransaction();
	  	Customer customer=new Customer();  //tansient
	    Scanner scanner=new Scanner(System.in);
	  	System.out.println("Enter the id");
	  	int id=scanner.nextInt();
	  	scanner.nextLine();
	  	System.out.println("Enter the name");
	  	String name=scanner.nextLine();
	  	System.out.println("Enter the address");
	  	String address=scanner.nextLine();
	  	customer.setId(id);
	  	customer.setCustomerName(name);
	  	customer.setAddress(address);
	  	  session.save(customer); //persistent
        transaction.commit(); 
        session.close();
        System.out.println(customer); //detached

	}

}

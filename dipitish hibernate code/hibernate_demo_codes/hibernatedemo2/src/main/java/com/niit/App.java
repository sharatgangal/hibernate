package com.niit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



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
	  	 Book book=new Book();
	     book.setId(1);
	     book.setBookname("Java");
	     book.setAuthor("Herbert");
	  	  session.save(book);
        transaction.commit(); 
        session.close();
	}

}

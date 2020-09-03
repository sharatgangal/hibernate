package com.stackroute.customer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.customer.model.Customer;

@Configuration
// @Configuration indicates that the class can be
// used by the Spring IOC container as a source of
// bean definitions
@EnableTransactionManagement 
// Enable Spring's annotation driven transaction management capability
public class ApplicationContextConfig {

	// DataSource bean ------> DriverManger's role
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/customerDB");
	    dataSource.setUsername("root");
	    dataSource.setPassword("password"); // change the password accordingly
	    return dataSource;
	}
	
	
	// SessionFactory bean
	@Bean
	// 3 Things being put with sessionFactory Bean
	//1) DataSource 
	//2) Hibernate Properties
	//3) The class whose object we are planning to persist
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto","update");
		hibernateProperties.put("hibernate.show_sql","true");
	    sessionFactoryBean.setAnnotatedClasses(Customer.class);
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    return sessionFactoryBean;
	}
	
	// We want to work under a transaction process so to ensure
	// either the transaction is complete or rollback to the previous state
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
	    return manager;
	}
	
	
}

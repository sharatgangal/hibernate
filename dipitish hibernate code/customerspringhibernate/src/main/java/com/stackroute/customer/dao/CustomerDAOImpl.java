package com.stackroute.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.customer.model.Customer;

@Repository
// is an annotation that marks the specific class as a Data Access Object.
// and stating the role of this class
@Transactional
//The transactional annotation itself defines the scope of a 
// single database transaction. The database transaction happens
// inside the scope of a persistence context
public class CustomerDAOImpl implements CustomerDAO {


	private SessionFactory sessionFactory;
	
	
	
	
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}





	@Override
	public boolean saveCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.save(customer);
		return true;
	}





	@Override
	public List<Customer> getAllCustomers() {
		String hqlString="FROM Customer customer ORDER BY customer.customerName";
		Query query=sessionFactory.getCurrentSession().createQuery(hqlString);
		List<Customer> customerList=query.getResultList();
		return customerList;
	}

}

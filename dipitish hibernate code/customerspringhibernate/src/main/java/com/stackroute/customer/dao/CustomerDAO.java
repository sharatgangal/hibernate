package com.stackroute.customer.dao;

import java.util.List;

import com.stackroute.customer.model.Customer;

public interface CustomerDAO {

	public boolean saveCustomer(Customer customer);

	public List<Customer> getAllCustomers();
}

package com.stackroute.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.customer.dao.CustomerDAO;
import com.stackroute.customer.model.Customer;

@Controller

// @Controller annotation is used to mark 
// any POJO class a controller so that Spring 
// framework can recognizw this class a Controller
public class CustomerController {

	
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	
	
	
	@RequestMapping("/")
	// http://localhost:8080/customermanagementhibernate
	public String getAllCustomers(ModelMap modelMap)
	{
		modelMap.addAttribute("customerList",customerDAO.getAllCustomers());
	    return "index";	
		
	}
	
	
	@RequestMapping("/addCustomer")
	public String addCustomer(ModelMap modelMap,@RequestParam String customerName, 	@RequestParam String customerAddress)
	{
		Customer customer=new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerAddress(customerAddress);
		customerDAO.saveCustomer(customer);
		modelMap.addAttribute("customerList", customerDAO.getAllCustomers());
		return "redirect:/";
	}
	
	
}

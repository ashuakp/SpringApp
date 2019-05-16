package com.sapiens.inspolicy.service;

import com.sapiens.inspolicy.model.*;
import java.util.List;

public interface CustomerService {
	

	 public List<Customer> getAllCustomers();
	 
	 public Customer getCustomerById(long id);
	 
	 public void saveOrUpdate(Customer customer);
	 
	 public void deleteCustomer(long id);
	 
}


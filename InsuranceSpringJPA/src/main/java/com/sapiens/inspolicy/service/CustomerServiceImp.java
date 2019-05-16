package com.sapiens.inspolicy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapiens.inspolicy.model.Customer;
import com.sapiens.inspolicy.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	 CustomerRepository customerRepository;

	 @Override
	 public List<Customer> getAllCustomers() {
	  return (List<Customer>) customerRepository.findAll();
	 }

	 @Override
	 public Customer getCustomerById(long id) {
	  return customerRepository.findById(id).get();
	 }

	 @Override
	 public void saveOrUpdate(Customer customer) {
		 customerRepository.save(customer);
	 }

	 @Override
	 public void deleteCustomer(long id) {
		 customerRepository.deleteById(id);
	 }

}
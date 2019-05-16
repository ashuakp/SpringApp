package com.sapiens.service;

import com.sapiens.customer.Customer;

public interface Service {
	void acceptRecord();
	Customer searchByName() throws Exception;
	Customer searchById() throws Exception;
	void createPolicy();
}

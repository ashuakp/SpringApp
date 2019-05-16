package com.sapiens.inspolicy.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapiens.inspolicy.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

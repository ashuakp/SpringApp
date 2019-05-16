package com.sapiens.service;

import java.util.Scanner;

import com.sapiens.customer.Customer;
import com.sapiens.dao.InsDao;
import com.sapiens.policy.Policy;

public class ServiceImp implements Service {
	static Customer customer = new Customer();
	static Policy policy = new Policy();
	static Scanner sc = new Scanner(System.in);
	
	public void acceptRecord() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name: ");
		customer.setName(sc.next());
		System.out.println("Enter City: ");
		customer.setAddress(sc.next());
		System.out.println("Enter Role : ");
		customer.setRole(sc.next());
		
		try(InsDao dao = new InsDao())
		{
			dao.insert(customer);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public Customer searchByName() throws Exception {
		// TODO Auto-generated method stub
		    try(InsDao dao = new InsDao()) {
			System.out.println("Enter Name:");
			String name = sc.next();
		    return dao.searchByName(name);
		    }
	    }
	public Customer searchById() throws Exception {
		// TODO Auto-generated method stub
		    try(InsDao dao = new InsDao()) {
			System.out.println("Enter Id:");
			int id = sc.nextInt();
		    return dao.searchById(id);
		    }
	    }
/*	Customer cust = searchById(); 
	{
	if(cust != null) {
		System.out.println("Enter Risk Location: ");
		policy.setRiskloc(sc.next());
		policy.setPid(generatePid());
		}
		else {
			throw new CustomerNotFoundException(); 
		}
	}
	@Override
	public void createPolicy() {
		// TODO Auto-generated method stub
		System.out.println("Enter Customer ID: ");
		policy.setPid(sc.next());
		System.out.println("Enter Risk Location: ");
		policy.setRiskloc(sc.next());
		
		try(InsDao dao = new InsDao())
		{
			dao.insert(policy);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		return;
		}
	}*/

	@Override
public void createPolicy() {
	// TODO Auto-generated method stub
	
}
}

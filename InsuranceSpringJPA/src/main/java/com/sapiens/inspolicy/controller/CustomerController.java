package com.sapiens.inspolicy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapiens.inspolicy.model.Customer;
import com.sapiens.inspolicy.service.CustomerService;

@Controller
//@RequestMapping(value="/customer")
public class CustomerController {

 @Autowired
 CustomerService customerService;
 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list() {
  ModelAndView model = new ModelAndView("customer_list");
  List<Customer> customerList = customerService.getAllCustomers();
  model.addObject("customerList", customerList);
  
  return model;
 }
 
 @RequestMapping(value="/addCustomer", method=RequestMethod.GET)
 public ModelAndView addCustomer() {
  ModelAndView model = new ModelAndView();
  
  Customer customer = new Customer();
  model.addObject("customerForm", customer);
  model.setViewName("customer_form");
  
  return model;
 }
 
 @RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
 public ModelAndView save(@ModelAttribute("customerForm") Customer customer) {
	 customerService.saveOrUpdate(customer);
  
  return new ModelAndView("redirect:/list");
 }
 
 @RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") long id) {
	 customerService.deleteCustomer(id);
  
  return new ModelAndView("redirect:/list");
 }

}

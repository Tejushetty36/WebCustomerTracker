package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customerList = customerService.getCustomers();
		
		theModel.addAttribute("customers",customerList);
		
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddCustomerForm(Model theModel) {
		
		Customer newCustomer = new Customer();
		
		theModel.addAttribute("Customer", newCustomer);
		
		return "customerForm";
		
	}
	
	@PostMapping("/saveCustomer")
	public String addNewCustomer(@ModelAttribute("Customer")Customer theCustomer) {
		
		customerService.addCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdateCustomer(@RequestParam("customerId")int theId,Model theModel)
	{
		Customer cust = customerService.getCustomerById(theId);
		
		theModel.addAttribute("Customer", cust);
		
		return "customerForm";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int theId)
	{
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName")String name,Model theModel) {
		
		List<Customer> searchList = customerService.searchCustomers(name);
		
		theModel.addAttribute("customers", searchList);
		
		return "listCustomers";
		
	}
	 
	
}

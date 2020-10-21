package com.springdemo.DAO;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> listCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomerById(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String name);

}

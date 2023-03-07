package com.medicare.backend.service;

import java.util.List;

import com.medicare.backend.entity.Customer;

public interface CustomerService {
	
	public Customer register(Customer cust);
	public Customer login(Customer cust);
	public List<Customer> getAllCustomers();
	public Customer getById(int id);
	public Customer updateProfile(Customer cust);
	public boolean deleteCustomer(int id);

}

package com.medicare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.backend.entity.Customer;
import com.medicare.backend.repository.CustomerRepo;

@Service 
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public Customer register(Customer cust) {
		return repo.save(cust);
	}

	@Override
	public Customer login(Customer cust) {
		return repo.findByName(cust.getEmail(), cust.getPassword());
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer getById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public Customer updateProfile(int id, Customer cust) { 
	if(repo.findById(id).isPresent()) {
		Customer oldCustomer = repo.findById(id).get();
		oldCustomer.setAddress(cust.getAddress());
		oldCustomer.setName(cust.getName());
		oldCustomer.setEmail(cust.getEmail());
		oldCustomer.setPassword(cust.getPassword());
	    Customer updatedCustomer = repo.save(oldCustomer);
		return new Customer(updatedCustomer.getId(), updatedCustomer.getAddress(), updatedCustomer.getEmail(), updatedCustomer.getName(), updatedCustomer.getPassword(), null);
		
	}
	else {
		return null;
	}
	}

	@Override
	public void deleteCustomerById(int id) {
		repo.deleteById(id);
	
	}

}

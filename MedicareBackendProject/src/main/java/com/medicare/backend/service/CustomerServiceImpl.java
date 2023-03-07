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
	public Customer updateProfile(Customer cust) {
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		return false;
	}

}

package com.medicare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.backend.entity.Customer;
import com.medicare.backend.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("")
	public ResponseEntity<Object> custRegistration(@RequestBody Customer cust){
		//calling method to save object and talking response in var name created
		Customer created= service.register(cust);
		if(created!=null)
		return new ResponseEntity<Object>(created,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while creating an object",HttpStatus.INTERNAL_SERVER_ERROR); 
		
	}
	@PostMapping("/login")
	public ResponseEntity<Object> custlogin(@RequestBody Customer cust){
		
		Customer created= service.login(cust);
		if(created!=null)
			return new ResponseEntity<Object>(created,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(" ")
	public List<Customer> getAll(){
		return service.getAllCustomers();
	}
	@RequestMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		if(service.getById(id)!=null)
			return new ResponseEntity<Object>(service.getById(id),HttpStatus.OK);
		return new ResponseEntity<Object>("No user Found", HttpStatus.NOT_FOUND);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public void deleteCustomerById(@PathVariable int id) {
		service.deleteCustomerById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	public ResponseEntity<Customer> updateProfile(@PathVariable int id, @RequestBody Customer cust) {
		
		return new ResponseEntity<Customer>(service.updateProfile(id, cust), HttpStatus.OK);
	}
	

}

package com.medicare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query("from Customer c where c.email=:email and c.password=:password")
	public Customer findByName(String email,String password);

}

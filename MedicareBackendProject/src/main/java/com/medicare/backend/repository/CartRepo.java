package com.medicare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Cart;
import com.medicare.backend.entity.Product;



@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	public Cart save(Product products);


}

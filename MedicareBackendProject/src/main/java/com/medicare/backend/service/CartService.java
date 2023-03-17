package com.medicare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.backend.entity.Cart;
import com.medicare.backend.entity.Product;
import com.medicare.backend.repository.CartRepo;
import com.medicare.backend.repository.CustomerRepo;
import com.medicare.backend.repository.ProductRepo;
@Service
public class CartService {
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private ProductRepo proRepo;
	@Autowired
	private CartRepo cartRepo;
	
	public Cart addProduct(Product products) {
		return cartRepo.save(products);
		
	}

	
	public List<Cart> getAllCart(){
		return cartRepo.findAll();
		
	}
	
	public Cart getCartById(int cartId) {
		return cartRepo.findById(cartId).get();
		
	}
	
	public void updateCart(Cart cart, int cartId) {
		cartRepo.save(cart);
	}
	
	public void deleteCart(Cart cart, int cartId) {
		cartRepo.deleteById(cartId);;
	}
	

}

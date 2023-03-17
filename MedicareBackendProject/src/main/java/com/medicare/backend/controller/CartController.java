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

import com.medicare.backend.entity.Cart;
import com.medicare.backend.entity.Product;
import com.medicare.backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("")
	public ResponseEntity<Cart> addProduct(@RequestBody Product products){
		
		Cart newCart = cartService.addProduct(products);
		if (newCart!=null)
			return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		else
			return new ResponseEntity<Cart>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@RequestMapping("")
	public List<Cart> getAllCart(){
		return cartService.getAllCart();
	}
	@RequestMapping("{cartId}")
	public Cart getCartById(@PathVariable int cartId) {
		return cartService.getCartById(cartId);
	}
	@RequestMapping(method =RequestMethod.PUT, value="{cartId}")
	public void updateCart(@RequestBody Cart cart, @PathVariable int cartId) {
		cartService.updateCart(cart, cartId);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="{cartId}")
	public void deleteCart(@PathVariable int id, @RequestBody Cart cart ) {
		cartService.deleteCart(cart, id);
	}

}

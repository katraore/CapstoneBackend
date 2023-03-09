package com.medicare.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.backend.entity.Product;
import com.medicare.backend.service.ProductService;



@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("")
	public ResponseEntity<Object> addProduct(@RequestBody Product pr){
		
		Product pcreated= pservice.addProduct(pr);
		if(pcreated!=null)
			return new ResponseEntity<Object>(pcreated, HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error while creating product",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	public List<Product> getAllProduct(){
		return pservice.getAllProducts();
	}
	
	public Product getProductById(@PathVariable int pid) {
		return pservice.getProductById(pid);
	}
	
	public void updateProduct(@RequestBody Product pr, @PathVariable int pid) {
	pservice.updateDescription(pr, pid);
	}
	
	public void deleteProduct(@PathVariable int pid) {
		pservice.deleteProduct(pid);
	}
	


	
	

}

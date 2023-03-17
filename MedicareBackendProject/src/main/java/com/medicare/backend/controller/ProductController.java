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

import com.medicare.backend.entity.Category;
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
	@RequestMapping(" ")
	public List<Product> getAllProduct(){
		return pservice.getAllProducts();
	}
	@RequestMapping("{pid}")
	public ResponseEntity<Object>  getProductById(@PathVariable int pid) {
		if(pservice.getProductById(pid)!=null)
			return new ResponseEntity<Object>(pservice.getProductById(pid), HttpStatus.OK);
		return new ResponseEntity<Object>("Error No Product found", HttpStatus.NOT_FOUND );
	}
	
	@RequestMapping(method =RequestMethod.PUT, value="{pid}")
	public void updateProduct(@RequestBody Product pr, @PathVariable int pid) {
	pservice.updateDescription(pr, pid);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{pid}")
	public void deleteProduct(@PathVariable int pid) {
		pservice.deleteProduct(pid);
	}
	
	@RequestMapping("{pname}")
	public ResponseEntity<Object> getProductByPname(@PathVariable String pname){
		if(pservice.getProductByPname(pname)!=null)
			return new ResponseEntity<Object>(pservice.getProductByPname(pname), HttpStatus.FOUND);
		return new ResponseEntity<Object>("Error No Product found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping("{category}")
	public ResponseEntity<Object> getAllProductsByCategory(@PathVariable Category category){
		if(pservice.getAllProductsByCategory(category)!=null)
			return new ResponseEntity<Object>(pservice.getAllProductsByCategory(category), HttpStatus.FOUND);
		return new ResponseEntity<Object>("Error No Category Found", HttpStatus.NOT_FOUND);
			
		
	}
	

}

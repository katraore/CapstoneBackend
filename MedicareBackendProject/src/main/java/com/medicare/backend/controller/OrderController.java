package com.medicare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.backend.entity.Order;
import com.medicare.backend.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService oservice;
	
	public ResponseEntity<Object> addOrder(@RequestBody Order order){
		
		Order ocreated = oservice.addOrder(order);
		if(ocreated!=null)
			return new ResponseEntity<Object>(ocreated, HttpStatus.CREATED);
					
			else
				return new ResponseEntity<Object>("Error while creating order", HttpStatus.INTERNAL_SERVER_ERROR);
				
	}

}

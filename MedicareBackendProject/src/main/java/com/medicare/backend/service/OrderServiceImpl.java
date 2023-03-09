package com.medicare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.backend.entity.Order;
import com.medicare.backend.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orepo;

	@Override
	public Order addOrder(Order order) {
		return orepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orepo.findAll();
	}

	@Override
	public Order getOrderById(int oid) {
		return orepo.findById(oid).get();
	}

	@Override
	public void updateOrder(Order order, int oid) {
		orepo.save(order);
		
	}

	@Override
	public void deleteOrderS(int oid) {
		orepo.deleteById(oid);
		
	}
	

	
}

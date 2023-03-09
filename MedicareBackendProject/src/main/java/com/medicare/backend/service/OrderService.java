package com.medicare.backend.service;

import java.util.List;

import com.medicare.backend.entity.Order;



public interface OrderService {
	public Order addOrder(Order order);
	public List<Order> getAllOrders();
	public Order getOrderById(int oid);
	public void updateOrder(Order order, int oid);
	public void deleteOrderS(int oid);

}

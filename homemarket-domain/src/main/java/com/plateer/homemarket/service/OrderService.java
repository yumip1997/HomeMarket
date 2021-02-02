package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Order;

public interface OrderService {
	
	public void register(Order order);
	public List<Order> findAll(String memberId);
	public Order find(int orderId);
	public void modfiy(Order order);
	public void remove(int orderId);

}

package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Order;

public interface OrderService {

	void register(Order order);
	List<Order> findAll(String memberId);
	Order find(int orderId);
	void modfiy(Order order);
	void remove(int productId, int orderId);

}

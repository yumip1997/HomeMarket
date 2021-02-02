package com.plateer.homemarket.store;

import java.util.List;

import com.plateer.homemarket.entity.Order;

public interface OrderStore {
	
	public void create(Order order);
	public List<Order> retrieveAll(String memberId);
	public Order retrieve(int orderId);
	public void update(Order order);
	public void delete(int orderId);

}

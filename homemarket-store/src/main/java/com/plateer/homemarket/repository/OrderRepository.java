package com.plateer.homemarket.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Order;
import com.plateer.homemarket.repository.mapper.OrderMapper;
import com.plateer.homemarket.store.OrderStore;

@Repository
public class OrderRepository implements OrderStore{
	
	private final OrderMapper orderMapper;
	
	public OrderRepository(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	

	@Override
	public void create(Order order) {
		// TODO Auto-generated method stub
		orderMapper.create(order);
	}

	@Override
	public List<Order> retrieveAll(String memberId) {
		// TODO Auto-generated method stub
		return orderMapper.retrieveAll(memberId);
	}

	@Override
	public Order retrieve(int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.retrieve(orderId);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderMapper.update(order);
	}

	@Override
	public void delete(int orderId) {
		// TODO Auto-generated method stub
		orderMapper.delete(orderId);
	}

}

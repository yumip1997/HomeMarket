package com.plateer.homemarket.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.Order;

@Mapper
public interface OrderMapper {
	
	public void create(Order order);
	public List<Order> retrieveAll(String memberId);
	public Order retrieve(int orderId);
	public void update(Order order);
	public void delete(int orderId);

}

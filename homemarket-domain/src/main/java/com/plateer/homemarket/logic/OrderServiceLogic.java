package com.plateer.homemarket.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Order;
import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.exception.OutofStockException;
import com.plateer.homemarket.service.OrderService;
import com.plateer.homemarket.store.OrderStore;
import com.plateer.homemarket.store.ProductStore;

@Service
public class OrderServiceLogic implements OrderService{
	
	private final OrderStore orderStore;
	private final ProductStore productStore;
	
	public OrderServiceLogic(OrderStore orderStore, ProductStore productStore) {
		this.orderStore = orderStore;
		this.productStore = productStore;
	}
	
	@Override
	public void register(Order order) {
		// TODO Auto-generated method stub
		Product product =productStore.retreive(order.getProductId());
		int nextQuantity = product.getQuantity() - order.getCount();
		if(nextQuantity <= 0) throw new OutofStockException("재고가 부족합니다!");
		
		orderStore.create(order);
		product.setQuantity(nextQuantity);
		productStore.update(product);
	}
	
	@Override
	public List<Order> findAll(String memberId) {
		// TODO Auto-generated method stub
		return orderStore.retrieveAll(memberId);
	}
	
	@Override
	public Order find(int orderId) {
		// TODO Auto-generated method stub
		return orderStore.retrieve(orderId);
	}
	
	@Override
	public void modfiy(Order order) {
		// TODO Auto-generated method stub
		Order prevOrder = orderStore.retrieve(order.getOrderId());
		Product product = productStore.retreive(order.getProductId());
		int nextQuantity = product.getQuantity() - (order.getCount() - prevOrder.getCount());
		
		if(nextQuantity <=0 ) throw new OutofStockException("We are out of stock!");
		orderStore.update(order);
		
		product.setQuantity(nextQuantity);
		productStore.update(product);
	}
	
	@Override
	public void remove(int productId, int orderId) {
		// TODO Auto-generated method stub
		Order prevOrder = orderStore.retrieve(orderId);
		Product product = productStore.retreive(productId);
		int nextQuantity = product.getQuantity() + prevOrder.getCount();
		
		orderStore.delete(orderId);
		
		product.setQuantity(nextQuantity);
		productStore.update(product);
	}
	
}

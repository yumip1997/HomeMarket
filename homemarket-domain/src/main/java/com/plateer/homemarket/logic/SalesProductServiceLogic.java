package com.plateer.homemarket.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.SalesProductService;
import com.plateer.homemarket.store.SalesProductStore;

@Service
public class SalesProductServiceLogic implements SalesProductService{
	
	private final SalesProductStore salesProductStore;
	
	public SalesProductServiceLogic(SalesProductStore salesProductStore) {
		this.salesProductStore = salesProductStore;
	}
	
	@Override
	public void register(Product product) {
		// TODO Auto-generated method stub
		salesProductStore.create(product);
	}

	@Override
	public List<Product> findAll(String memberId) {
		// TODO Auto-generated method stub
		return salesProductStore.retrieveAll(memberId);
	}

	@Override
	public List<Product> findByName(String productName, String memberId) {
		// TODO Auto-generated method stub
		return salesProductStore.retrieveByName(productName, memberId);
	}

	@Override
	public Product find(int productId) {
		// TODO Auto-generated method stub
		return salesProductStore.retrieve(productId);
	}

	@Override
	public void modify(Product product) {
		// TODO Auto-generated method stub
		salesProductStore.update(product);
	}

	@Override
	public void remove(int productId) {
		// TODO Auto-generated method stub
		salesProductStore.delete(productId);
	}

}

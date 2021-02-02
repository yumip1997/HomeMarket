package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Product;

public interface SalesProductService {
	
	public void register(Product product);
	public List<Product> findAll(String memberId);
	public List<Product> findByName(String productName, String memberId);
	public Product find(int productId);
	public void modify(Product product);
	public void remove(int productId);

}

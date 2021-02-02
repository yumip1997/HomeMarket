package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public List<Product> findByCategories(String categories);
	public List<Product> findByName(String productName);	
	public Product find(int productId);
}

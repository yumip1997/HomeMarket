package com.plateer.homemarket.store;

import java.util.List;

import com.plateer.homemarket.entity.Product;

public interface ProductStore {
	
	public List<Product> retrieveAll();
	public List<Product> retrieveByCategories(String categories);
	public List<Product> retrieveByName(String productName);
	public Product retreive(int productId);
	
}

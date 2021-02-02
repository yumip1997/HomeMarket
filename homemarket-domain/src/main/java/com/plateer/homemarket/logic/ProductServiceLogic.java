package com.plateer.homemarket.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.ProductService;
import com.plateer.homemarket.store.ProductStore;

@Service
public class ProductServiceLogic implements ProductService{
	
	private final ProductStore productStore;
	
	public ProductServiceLogic(ProductStore productStore) {
		this.productStore = productStore;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productStore.retrieveAll();
	}

	@Override
	public List<Product> findByCategories(String categories) {
		// TODO Auto-generated method stub
		return productStore.retrieveByCategories(categories);
	}

	@Override
	public List<Product> findByName(String productName) {
		// TODO Auto-generated method stub
		return productStore.retrieveByName(productName);
	}

	@Override
	public Product find(int productId) {
		// TODO Auto-generated method stub
		return productStore.retreive(productId);
	}
	
	
	
}

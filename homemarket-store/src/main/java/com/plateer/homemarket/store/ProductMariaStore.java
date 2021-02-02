package com.plateer.homemarket.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.store.mapper.ProductMapper;

@Repository
public class ProductMariaStore implements ProductStore{
	
	private final ProductMapper productMapper;
	
	public ProductMariaStore(ProductMapper productMapper){
		this.productMapper = productMapper;
	}

	@Override
	public List<Product> retrieveAll() {
		// TODO Auto-generated method stub
		return productMapper.retrieveAll();
	}

	@Override
	public List<Product> retrieveByCategories(String categories) {
		// TODO Auto-generated method stub
		return productMapper.retrieveByCategories(categories);
	}

	@Override
	public List<Product> retrieveByName(String productName) {
		// TODO Auto-generated method stub
		return productMapper.retrieveByName(productName);
	}

	@Override
	public Product retreive(int productId) {
		// TODO Auto-generated method stub
		return productMapper.retrieve(productId);
	}
	
	

}

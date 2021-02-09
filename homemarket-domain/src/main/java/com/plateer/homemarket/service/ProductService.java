package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.dto.MyProductDto;

public interface ProductService {
	
	void register(Product product);
	
	List<Product> findAll();
	List<MyProductDto> findAllMyOrderedproduct(String seller);
	List<Product> findAllByMemberId(String memberId);
	List<Product> findByCategories(String categories);
	List<Product> findByName(String productName);	
	List<Product> findByNameMemberId(String productName, String memberId);
	Product find(int productId);
	
	void modify(Product product);
	
	void remove(int productId);
}

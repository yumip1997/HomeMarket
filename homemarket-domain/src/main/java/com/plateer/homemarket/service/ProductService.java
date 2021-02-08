package com.plateer.homemarket.service;

import java.util.List;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.dto.MyProductDto;

public interface ProductService {
	
	public void register(Product product);
	
	public List<Product> findAll();
	public List<MyProductDto> findAllMyOrderedproduct(String memberId);
	public List<Product> findAllByMemberId(String memberId);
	public List<Product> findByCategories(String categories);
	public List<Product> findByName(String productName);	
	public List<Product> findByNameMemberId(String productName, String memberId);
	public Product find(int productId);
	
	public void modify(Product product);
	
	public void remove(int productId);
}

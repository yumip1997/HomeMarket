package com.plateer.homemarket.store;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.dto.MyProductDto;

public interface ProductStore {
	
	public void create(Product product);
	
	public List<Product> retrieveAll();
	public List<MyProductDto> retrieveAllMyOrderedproduct(String seller);
	public List<Product> retrieveAllByMemberId(String memberId);
	public List<Product> retrieveByCategories(String categories);
	public List<Product> retrieveByName(String productName);
	public List<Product> retrieveByNameMemberId(@Param("productName")String productName, @Param("memberId")String memberId);
	public Product retreive(int productId);
	
	public void update(Product product);
	
	public void delete(int productId);
}

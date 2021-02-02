package com.plateer.homemarket.store;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plateer.homemarket.entity.Product;

public interface SalesProductStore {
	
	public void create(Product product);
	public List<Product> retrieveAll(String memberId);
	public List<Product> retrieveByName(@Param("productName")String productName, @Param("memberId")String memberId);
	public Product retrieve(int productId);
	public void update(Product product);
	public void delete(int productId);
}

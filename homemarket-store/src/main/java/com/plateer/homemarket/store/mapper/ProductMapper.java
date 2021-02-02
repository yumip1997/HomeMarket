package com.plateer.homemarket.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.Product;

@Mapper
public interface ProductMapper {

	public List<Product> retrieveAll();
	public List<Product> retrieveByCategories(String categories);
	public List<Product> retrieveByName(String productName);
	public Product retrieve(int productId);
}

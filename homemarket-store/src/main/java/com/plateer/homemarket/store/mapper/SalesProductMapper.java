package com.plateer.homemarket.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.Product;

@Mapper
public interface SalesProductMapper {
	public void create(Product product);
	public List<Product> retrieveAll(String memberId);
	public List<Product> retrieveByName(String productName, String memberId);
	public Product retrieve(int productId);
	public void update(Product product);
	public void delete(int productId);
}

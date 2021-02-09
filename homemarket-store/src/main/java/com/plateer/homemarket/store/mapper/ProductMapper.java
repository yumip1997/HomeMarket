package com.plateer.homemarket.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.dto.MyProductDto;

@Mapper
public interface ProductMapper {

	public void create(Product product);
	
	public List<Product> retrieveAll();
	public List<MyProductDto> retrieveAllMyorderedProduct(String seller);
	public List<Product> retrieveAllByMemberId(String memberId);
	public List<Product> retrieveByCategories(String categories);
	public List<Product> retrieveByName(String productName);
	public List<Product> retrieveByNameMemberId(@Param("productName")String productName, @Param("memberId")String memberId);
	public Product retrieve(int productId);
	
	public void update(Product product);
	
	public void delete(int productId);
}

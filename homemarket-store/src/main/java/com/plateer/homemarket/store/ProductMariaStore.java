package com.plateer.homemarket.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.dto.MyProductDto;
import com.plateer.homemarket.store.mapper.ProductMapper;

@Repository
public class ProductMariaStore implements ProductStore{
	
	private final ProductMapper productMapper;
	
	public ProductMariaStore(ProductMapper productMapper){
		this.productMapper = productMapper;
	}
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		productMapper.create(product);
	}

	@Override
	public List<Product> retrieveAll() {
		// TODO Auto-generated method stub
		return productMapper.retrieveAll();
	}
	
	@Override
	public List<Product> retrieveAllByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return productMapper.retrieveAllByMemberId(memberId);
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
	public List<Product> retrieveByNameMemberId(String productName, String memberId) {
		// TODO Auto-generated method stub
		return productMapper.retrieveByNameMemberId(productName, memberId);
	}

	@Override
	public Product retreive(int productId) {
		// TODO Auto-generated method stub
		return productMapper.retrieve(productId);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productMapper.update(product);
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		productMapper.delete(productId);
	}

	@Override
	public List<MyProductDto> retrieveAllMyOrderedproduct(String seller) {
		// TODO Auto-generated method stub
		return productMapper.retrieveAllMyorderedProduct(seller);
	}

}

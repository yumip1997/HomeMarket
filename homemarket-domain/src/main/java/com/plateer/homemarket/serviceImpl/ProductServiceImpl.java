package com.plateer.homemarket.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.ProductService;
import com.plateer.homemarket.service.dto.MyProductDto;
import com.plateer.homemarket.store.ProductStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductStore productStore;

	@Override
	public void register(Product product) {
		// TODO Auto-generated method stub
		productStore.create(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productStore.retrieveAll();
	}
	
	@Override
	public List<Product> findAllByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return productStore.retrieveAllByMemberId(memberId);
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
	public List<Product> findByNameMemberId(String productName, String memberId) {
		// TODO Auto-generated method stub
		return productStore.retrieveByNameMemberId(productName, memberId);
	}

	@Override
	public Product find(int productId) {
		// TODO Auto-generated method stub
		return productStore.retreive(productId);
	}

	@Override
	public void modify(Product product) {
		// TODO Auto-generated method stub
		productStore.update(product);
	}

	@Override
	public void remove(int productId) {
		// TODO Auto-generated method stub
		productStore.delete(productId);
	}

	@Override
	public List<MyProductDto> findAllMyOrderedproduct(String seller) {
		// TODO Auto-generated method stub
		return productStore.retrieveAllMyOrderedproduct(seller);
	}
	
	
}

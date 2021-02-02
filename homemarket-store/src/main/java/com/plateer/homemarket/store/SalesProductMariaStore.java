package com.plateer.homemarket.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.store.mapper.SalesProductMapper;

@Repository
public class SalesProductMariaStore implements SalesProductStore{
	
	private final SalesProductMapper salesProductMapper;
	
	SalesProductMariaStore(SalesProductMapper salesProductMapper){
		this.salesProductMapper = salesProductMapper;
	}

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		salesProductMapper.create(product);
	}

	@Override
	public List<Product> retrieveAll(String memberId) {
		// TODO Auto-generated method stub
		return salesProductMapper.retrieveAll(memberId);
	}

	@Override
	public List<Product> retrieveByName(String productName, String memberId) {
		// TODO Auto-generated method stub
		return salesProductMapper.retrieveByName(productName, memberId);
	}

	@Override
	public Product retrieve(int productId) {
		// TODO Auto-generated method stub
		return salesProductMapper.retrieve(productId);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		salesProductMapper.update(product);
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		salesProductMapper.delete(productId);
	}

}

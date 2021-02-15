package com.plateer.homemarket.repository;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.CustomUser;
import com.plateer.homemarket.repository.mapper.SecureMapper;
import com.plateer.homemarket.store.SecureStore;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SecureRepository implements SecureStore{
	
	private final SecureMapper secureMapper;

	@Override
	public void create(CustomUser customeUser) {
		// TODO Auto-generated method stub
		secureMapper.create(customeUser);
	}

	@Override
	public CustomUser retrieve(String memberId) {
		// TODO Auto-generated method stub
		return secureMapper.retrieve(memberId);
	}
	

}

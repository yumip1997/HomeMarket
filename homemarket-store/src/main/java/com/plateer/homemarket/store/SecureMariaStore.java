package com.plateer.homemarket.store;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.CustomUser;
import com.plateer.homemarket.store.mapper.SecureMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SecureMariaStore implements SecureStore{
	
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

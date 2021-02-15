package com.plateer.homemarket.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.CustomUser;

@Mapper
public interface SecureMapper {
	
	void create(CustomUser customUser);
	CustomUser retrieve(String memberId);

}

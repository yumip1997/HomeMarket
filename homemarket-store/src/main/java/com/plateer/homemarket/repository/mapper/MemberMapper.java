package com.plateer.homemarket.repository.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.service.dto.UserDto;

@Mapper
public interface MemberMapper {
	public void create(Member member);
	public List<Member> retrieveAll();
	public Member retrieveById(String memberId);
	public List<Member> retrieveByName(String name);
	public void update(Member member);
	public void delete(String memberId);
	
	public UserDto retrieveByIdForLogin(String memberId);
}

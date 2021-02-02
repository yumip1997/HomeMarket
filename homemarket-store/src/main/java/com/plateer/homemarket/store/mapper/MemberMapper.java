package com.plateer.homemarket.store.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.homemarket.entity.Member;

@Mapper
public interface MemberMapper {
	public void create(Member member);
	public List<Member> retrieveAll();
	public Member retrieveById(String memberId);
	public List<Member> retrieveByName(String name);
	public void update(Member member);
	public void delete(String memberId);
}

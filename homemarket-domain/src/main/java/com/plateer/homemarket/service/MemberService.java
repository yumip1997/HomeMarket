package com.plateer.homemarket.service;


import java.util.List;

import com.plateer.homemarket.entity.Member;

public interface MemberService {
	
	void register(Member member);
	List<Member> findAll();
	Member findById(String memberId);
	List<Member> findByName(String name);
	void modify(Member member);
	void remove(String memberId);

}

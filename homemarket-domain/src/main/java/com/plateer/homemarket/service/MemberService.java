package com.plateer.homemarket.service;


import java.util.List;

import com.plateer.homemarket.entity.Member;

public interface MemberService {
	
	public void register(Member member);
	public List<Member> findAll();
	public Member findById(String memberId);
	public List<Member> findByName(String name);
	public void modify(Member member);
	public void remove(String memberId);

}

package com.plateer.homemarket.store;


import java.util.List;

import com.plateer.homemarket.entity.Member;

public interface MemberStore {
	
	void create(Member member);
	List<Member> retrieveAll();
	public Member retrieveById(String memberId);
	public List<Member> retrieveByName(String name);
	public void modify(Member member);
	public void remove(String memberId);
	
	public boolean retireveByIdPw(String memberId, String password);
}

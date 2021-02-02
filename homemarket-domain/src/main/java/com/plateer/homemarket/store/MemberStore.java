package com.plateer.homemarket.store;


import java.util.List;

import com.plateer.homemarket.entity.Member;

public interface MemberStore {
	
	public void create(Member member);
	public List<Member> retrieveAll();
	public Member retrieveById(String memberId);
	public List<Member> retrieveByName(String name);
	public void modify(Member member);
	public void remove(String memberId);

}

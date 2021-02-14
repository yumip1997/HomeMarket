package com.plateer.homemarket.store;


import java.util.List;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.service.dto.UserDto;

public interface MemberStore {
	
	void create(Member member);
	List<Member> retrieveAll();
	public Member retrieveById(String memberId);
	public List<Member> retrieveByName(String name);
	public void modify(Member member);
	public void remove(String memberId);
	
	public UserDto retrieveByIdForLogin(String memberId);
	
}

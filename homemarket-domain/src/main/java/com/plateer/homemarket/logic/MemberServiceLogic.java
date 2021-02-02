package com.plateer.homemarket.logic;


import java.util.List;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.service.MemberService;
import com.plateer.homemarket.store.MemberStore;

@Service
public class MemberServiceLogic implements MemberService{
	
	private final MemberStore memberStore;
	
	public MemberServiceLogic(MemberStore memberStore) {
		this.memberStore = memberStore;
	}
	
	@Override
	public void register(Member member) {
		// TODO Auto-generated method stub
		memberStore.create(member);
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberStore.retrieveAll();
	}

	@Override
	public Member findById(String memberId) {
		// TODO Auto-generated method stub
		return memberStore.retrieveById(memberId);
	}

	@Override
	public List<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return memberStore.retrieveByName(name);
	}

	@Override
	public void modify(Member member) {
		// TODO Auto-generated method stub
		memberStore.modify(member);
	}

	@Override
	public void remove(String memberId) {
		// TODO Auto-generated method stub
		memberStore.remove(memberId);
	}

}

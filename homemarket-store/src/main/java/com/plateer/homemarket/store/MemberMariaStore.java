package com.plateer.homemarket.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.store.mapper.MemberMapper;

@Repository
public class MemberMariaStore implements MemberStore{

	private final MemberMapper memberMapper;
	
	public MemberMariaStore(MemberMapper memberMapper){
		this.memberMapper = memberMapper;
	}

	@Override
	public void create(Member member) {
		// TODO Auto-generated method stub
		memberMapper.create(member);
		
	}

	@Override
	public List<Member> retrieveAll() {
		// TODO Auto-generated method stub
		return memberMapper.retrieveAll();
	}

	@Override
	public Member retrieveById(String memberId) {
		// TODO Auto-generated method stub
		return memberMapper.retrieveById(memberId);
	}

	@Override
	public List<Member> retrieveByName(String name) {
		// TODO Auto-generated method stub
		return memberMapper.retrieveByName(name);
	}

	@Override
	public void modify(Member member) {
		// TODO Auto-generated method stub
		memberMapper.update(member);
	}

	@Override
	public void remove(String memberId) {
		// TODO Auto-generated method stub
		memberMapper.delete(memberId);
	}

	@Override
	public boolean retireveByIdPw(String memberId, String password) {
		// TODO Auto-generated method stub
		return memberMapper.retrieveByIdPw(memberId, password);
	}
}

package com.plateer.homemarket.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.service.LoginService;
import com.plateer.homemarket.service.dto.UserDto;
import com.plateer.homemarket.store.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberStore{

	private final MemberMapper memberMapper;
	
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
	public UserDto retrieveByIdForLogin(String memberId) {
		// TODO Auto-generated method stub
		return memberMapper.retrieveByIdForLogin(memberId);
	}
	
}

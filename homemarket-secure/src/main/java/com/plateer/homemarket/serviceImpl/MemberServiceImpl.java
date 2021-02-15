package com.plateer.homemarket.serviceImpl;


import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.entity.enumType.Role;
import com.plateer.homemarket.service.MemberService;
import com.plateer.homemarket.store.MemberStore;
import com.plateer.homemarket.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberStore memberStore;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	@Override
	public void register(Member member) {
		// TODO Auto-generated method stub
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.getRoles().add(Role.ROLE_USER);
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

package com.plateer.homemarket.logic;

import org.springframework.stereotype.Service;

import com.plateer.homemarket.service.LoginService;
import com.plateer.homemarket.store.MemberStore;

@Service
public class LoginServiceLogic implements LoginService{
	
	private final MemberStore memberStore;
	
	public LoginServiceLogic(MemberStore memberStore) {
		this.memberStore = memberStore;
	}

	@Override
	public boolean findByIdPw(String memberId, String password) {
		// TODO Auto-generated method stub
		return memberStore.retireveByIdPw(memberId, password);
	}

}

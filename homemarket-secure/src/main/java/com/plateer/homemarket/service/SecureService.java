package com.plateer.homemarket.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.plateer.homemarket.entity.CustomUser;
import com.plateer.homemarket.store.SecureStore;
import com.plateer.homemarket.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecureService {
	
	private final SecureStore secureStore;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	public void join(CustomUser customUser) {
		
		customUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
		customUser.getRoles().add("ROLE_USER");
		
		secureStore.create(customUser);
	}
	
//	public String Login(CustomUser customUser) {
//		
//		//user : DB에서 가져온 user
//		CustomUser user  = Optional.ofNullable(secureStore.retrieve(customUser.getMemberId()))
//				.orElseThrow(() -> new UsernameNotFoundException("No Such MemberId with --->" + customUser.getMemberId()));
//		if(!passwordEncoder.matches(customUser.getPassword(), user.getPassword())) {
//			throw new IllegalArgumentException("Password not correct");
//		}
//		
//		return jwtUtil.createAccessToken(user.getUsername(), user.getRoles());
//	}
}

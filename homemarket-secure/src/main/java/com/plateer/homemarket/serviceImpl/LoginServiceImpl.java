package com.plateer.homemarket.serviceImpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.plateer.homemarket.service.LoginService;
import com.plateer.homemarket.service.dto.JwtDto;
import com.plateer.homemarket.service.dto.UserDto;
import com.plateer.homemarket.store.MemberStore;
import com.plateer.homemarket.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
	
	private final MemberStore memberStore;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	@Override
	public JwtDto findByIdForLogin(UserDto userDto) {
		// TODO Auto-generated method stub
		UserDto realUser = Optional.ofNullable(memberStore.retrieveByIdForLogin(userDto.getMemberId()))
				.orElseThrow(() -> new UsernameNotFoundException("No Such Member with : " + userDto.getMemberId()));
				
		if(!passwordEncoder.matches(userDto.getPassword(), realUser.getPassword())) {
			throw new IllegalArgumentException("Invalid Login or password");
		}
		
		String jwt  = jwtUtil.createAccessToken(realUser.getMemberId(), realUser.getRoles());
		
		return new JwtDto(jwt, realUser.getMemberId(), realUser.getRoles());
	}
}

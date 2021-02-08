package com.plateer.homemarket.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plateer.homemarket.store.SecureStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private final SecureStore secureStore;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(secureStore.retrieve(username))
				.orElseThrow(() -> new UsernameNotFoundException("no user with memberId --->" + username));
	}

}

package com.plateer.homemarket.service;

import com.plateer.homemarket.service.dto.UserDto;

public interface LoginService {
	
	String findByIdForLogin(UserDto userDto);
}

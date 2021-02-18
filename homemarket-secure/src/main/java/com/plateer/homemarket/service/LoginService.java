package com.plateer.homemarket.service;

import com.plateer.homemarket.service.dto.JwtDto;
import com.plateer.homemarket.service.dto.UserDto;

public interface LoginService {
	
	JwtDto findByIdForLogin(UserDto userDto);
}

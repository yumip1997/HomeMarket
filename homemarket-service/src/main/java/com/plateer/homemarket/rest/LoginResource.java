package com.plateer.homemarket.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.service.LoginService;
import com.plateer.homemarket.service.dto.UserDto;

@RestController
@RequestMapping("/login")
public class LoginResource {
	
	private final LoginService loginService;
	
	public LoginResource(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@PostMapping("/loginCheck")
	public boolean login(@RequestBody UserDto userDto) {
		return loginService.findByIdPw(userDto.getMemberId(), userDto.getPassword());
	}

}

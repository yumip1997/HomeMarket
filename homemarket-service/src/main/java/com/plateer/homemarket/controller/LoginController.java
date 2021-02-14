package com.plateer.homemarket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.service.LoginService;
import com.plateer.homemarket.service.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
	
	private final LoginService loginService;
	
	@PostMapping("/loginCheck")
	public String login(@RequestBody UserDto userDto) {
		return loginService.findByIdForLogin(userDto);
	}

}

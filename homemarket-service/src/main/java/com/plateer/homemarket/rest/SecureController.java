package com.plateer.homemarket.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.CustomUser;
import com.plateer.homemarket.service.SecureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class SecureController {
	
	private final SecureService secureService;
	
	@PostMapping("/register")
	public void join(@RequestBody CustomUser customUser) {
		secureService.join(customUser);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody CustomUser customUser) {
		return secureService.Login(customUser);
	}
}

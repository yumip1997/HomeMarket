package com.plateer.homemarket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
	
	private String memberId;
	private String name;
	private String password;
	private String email;
	private String address;
	private String joinDate;
	private String auth;

}

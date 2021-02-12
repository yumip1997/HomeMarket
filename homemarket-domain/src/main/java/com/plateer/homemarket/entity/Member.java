package com.plateer.homemarket.entity;

import java.util.List;

import com.plateer.homemarket.entity.enumType.Authority;

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
	private String joinDate;
	private List<Address> address;
	private Authority authority;

}

package com.plateer.homemarket.service.dto;

import java.util.List;

import com.plateer.homemarket.entity.enumType.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private String memberId;
	private String password;
	private List<Role> roles;
}

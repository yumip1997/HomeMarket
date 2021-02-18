package com.plateer.homemarket.service.dto;

import java.util.List;

import com.plateer.homemarket.entity.enumType.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtDto {
	
	private String accessToken;
	private String type = "Bearer";
	private String memberId;
	private List<Role> roles;
	
	public JwtDto(String accessToken, String memberId, List<Role> roles) {
		this.accessToken = accessToken;
		this.memberId = memberId;
		this.roles = roles;
	}

}

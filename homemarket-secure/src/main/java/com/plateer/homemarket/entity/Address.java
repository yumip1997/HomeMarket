package com.plateer.homemarket.entity;

import com.plateer.homemarket.entity.enumType.AddressType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {
	
	private String zipCode;
	private String zipAddress;
	private String streetAddress;
	private AddressType addressType;
	
}

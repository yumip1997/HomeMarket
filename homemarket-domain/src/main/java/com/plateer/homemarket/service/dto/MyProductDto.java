package com.plateer.homemarket.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyProductDto {
	
	private int productId;
	private int orderId;
	private String productNmae;
	private String seller;
	private String buyer;
	private String state;
	private int stock;
	private int count;
	

}

package com.plateer.homemarket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	
	private int orderId;
	private int productId;
	private String productName;
	private int count;
	private String state;
	private String address;
	private String memberId;
	private String orderDate;
}

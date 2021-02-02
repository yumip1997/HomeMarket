package com.plateer.homemarket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private String productDetail;
	private String categories;
	private int quantity;
	private int price;
	private String memberId;
	private String uploadDate;
	

}

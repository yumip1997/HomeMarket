package com.plateer.homemarket.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	private final ProductService productService;
	
	public ProductResource(ProductService productService){
		this.productService = productService;
	}
	
	@GetMapping("/retrieveAll")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/retrieveByCategories")
	public List<Product> findByCategories(String categories){
		return productService.findByCategories(categories);
	}
	
	@GetMapping("/retrieveByName")
	public List<Product> findByName(String productName){
		return productService.findByName(productName);
	}
	
	@GetMapping("/retrieve")
	public Product find(int productId) {
		return productService.find(productId);
	}

}

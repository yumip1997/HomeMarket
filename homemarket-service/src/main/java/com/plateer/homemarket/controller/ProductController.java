package com.plateer.homemarket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.ProductService;
import com.plateer.homemarket.service.dto.MyProductDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping("/create")
	public void register(@RequestBody Product product) {
		productService.register(product);
	}
	
	@GetMapping("/retrieveAll")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/retrieveOrderedProduct")
	public List<MyProductDto> findAllOrderedProduct(@RequestParam String seller){
		return productService.findAllMyOrderedproduct(seller);
	}
	
	@GetMapping("/retrieveAllById")
	public List<Product> findAll(@RequestParam String memberId) {
		return productService.findAllByMemberId(memberId);
	}
	
	@GetMapping("/retrieveByCategories")
	public List<Product> findByCategories(@RequestParam String categories){
		return productService.findByCategories(categories);
	}
	
	@GetMapping("/retrieveByName")
	public List<Product> findByName(@RequestParam String productName){
		return productService.findByName(productName);
	}
	
	@GetMapping("/retrieveByNameId")
	public List<Product> findByName(@RequestParam String productName, @RequestParam String memberId){
		return productService.findByNameMemberId(productName, memberId);
	}
	
	@GetMapping("/retrieve")
	public Product find(@RequestParam int productId) {
		return productService.find(productId);
	}
	
	@PostMapping("/update")
	public void modify(@RequestBody Product product) {
		productService.modify(product);
	}
	
	@DeleteMapping("/delete")
	public void remove(@RequestParam int productId) {
		productService.remove(productId);
	}

}

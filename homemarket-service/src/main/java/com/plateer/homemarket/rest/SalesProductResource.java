package com.plateer.homemarket.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.Product;
import com.plateer.homemarket.service.SalesProductService;

@RestController
@RequestMapping("/salesProduct")
public class SalesProductResource {
	
	private final SalesProductService salesProductService;
	
	public SalesProductResource(SalesProductService salesProductService){
		this.salesProductService = salesProductService;
	}
	
	@PostMapping("/create")
	public void register(@RequestBody Product product) {
		salesProductService.register(product);
	}
	
	@GetMapping("/retrieveAll")
	public List<Product> findAll(@RequestParam String memberId) {
		return salesProductService.findAll(memberId);
	}
	
	@GetMapping("/retrieveByName")
	public List<Product> findByName(@RequestParam String productName, @RequestParam String memberId){
		return salesProductService.findByName(productName, memberId);
	}
	
	@GetMapping("/retrieve")
	public Product find(@RequestParam int productId) {
		return salesProductService.find(productId);
	}
	
	@PostMapping("/update")
	public void modify(@RequestBody Product product) {
		salesProductService.modify(product);
	}
	
	@DeleteMapping("/delete")
	public void remove(@RequestParam int productId) {
		salesProductService.remove(productId);
	}
	

}

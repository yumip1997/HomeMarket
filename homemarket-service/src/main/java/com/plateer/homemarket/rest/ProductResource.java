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
import com.plateer.homemarket.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	private final ProductService productService;
	
	public ProductResource(ProductService productService){
		this.productService = productService;
	}
	
	@PostMapping("/create")
	public void register(@RequestBody Product product) {
		productService.register(product);
	}
	
	@GetMapping("/retrieveAll")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/retrieveAllById")
	public List<Product> findAll(@RequestParam String memberId) {
		return productService.findAllByMemberId(memberId);
	}
	
	@GetMapping("/retrieveByCategories")
	public List<Product> findByCategories(String categories){
		return productService.findByCategories(categories);
	}
	
	@GetMapping("/retrieveByName")
	public List<Product> findByName(String productName){
		return productService.findByName(productName);
	}
	
	@GetMapping("/retrieveByNameId")
	public List<Product> findByName(@RequestParam String productName, @RequestParam String memberId){
		return productService.findByNameMemberId(productName, memberId);
	}
	
	@GetMapping("/retrieve")
	public Product find(int productId) {
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

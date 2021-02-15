package com.plateer.homemarket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.Order;
import com.plateer.homemarket.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping("/create")
	public void register(@RequestBody Order order) {
		orderService.register(order);
	}
	
	@GetMapping("/retrieveAll")
	public List<Order> findAll(@RequestParam String memberId){
		return orderService.findAll(memberId);
	}
	
	@GetMapping("/retrieve")
	public Order find(@RequestParam int orderId) {
		return orderService.find(orderId);
	}
	
	@PutMapping("/update")
	public void modify(@RequestBody Order order) {
		orderService.modfiy(order);
	}
	
	@DeleteMapping("/delete")
	public void remove(@RequestParam int productId, @RequestParam int orderId) {
		orderService.remove(productId, orderId);
	}
	
}

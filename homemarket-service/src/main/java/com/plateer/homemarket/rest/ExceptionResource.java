package com.plateer.homemarket.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.plateer.homemarket.exception.OutofStockException;


@RestControllerAdvice
public class ExceptionResource {
	
	@ExceptionHandler(OutofStockException.class)
	public ResponseEntity<?> stockError(HttpServletRequest request, OutofStockException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

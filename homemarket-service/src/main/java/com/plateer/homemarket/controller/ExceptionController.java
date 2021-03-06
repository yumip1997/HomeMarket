package com.plateer.homemarket.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.plateer.homemarket.exception.OutofStockException;
import com.plateer.homemarket.service.dto.ExceptionDto;


@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(OutofStockException.class)
	public ExceptionDto stockError(OutofStockException e){
		ExceptionDto exceptionDto = new ExceptionDto("재고부족", e.getMessage());
		return exceptionDto;
	}
}

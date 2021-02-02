package com.plateer.homemarket.exception;

public class OutofStockException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public OutofStockException(String message) {
		super(message);
	}
}

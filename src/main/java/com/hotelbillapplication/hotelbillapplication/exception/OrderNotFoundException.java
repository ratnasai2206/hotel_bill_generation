package com.hotelbillapplication.hotelbillapplication.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message = "Order Not found";

	public String getMessage() {
		return message;
	}

	public OrderNotFoundException() {

	}

	public OrderNotFoundException(String message) {
		this.message = message;
	}

}

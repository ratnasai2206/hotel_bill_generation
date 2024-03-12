package com.hotelbillapplication.hotelbillapplication.exception;

public class OrdersNotSaveException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message = "Order Not Save";

	public String getMessage() {
		return message;
	}

	public OrdersNotSaveException() {

	}

	public OrdersNotSaveException(String message) {
		this.message = message;
	}
}

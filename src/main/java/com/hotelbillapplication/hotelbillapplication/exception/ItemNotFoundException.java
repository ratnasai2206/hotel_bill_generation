package com.hotelbillapplication.hotelbillapplication.exception;

public class ItemNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	public ItemNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}

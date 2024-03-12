package com.hotelbillapplication.hotelbillapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchOrderNotFoundException(
			OrderNotFoundException notFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Order Not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(notFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrdersNotSaveException.class)
	public ResponseEntity<ResponseStructure<String>> catchOrderNotSaveFoundException(
			OrderNotFoundException notFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Order Not Save ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(notFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleItemNotFoundException(ItemNotFoundException exception){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage("Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
		
}

package com.hotelbillapplication.hotelbillapplication.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;

import com.hotelbillapplication.hotelbillapplication.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/perday")
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprise(@RequestParam LocalDate date){
		return orderService.caliclatedayprise(date);
	}
	
	
}

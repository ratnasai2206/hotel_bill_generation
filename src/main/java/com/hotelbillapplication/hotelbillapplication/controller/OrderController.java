package com.hotelbillapplication.hotelbillapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.services.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/")
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody OrderDto orderDto) {
		return orderService.saveOrder(orderDto);
	}

	@PutMapping(value = "/{orderId}")
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@PathVariable int orderId,@RequestBody OrderDto orderDto) {
		return orderService.updateOrders(orderId,orderDto);
	}

	@GetMapping(value = "/get-order/{orderId}")
	public ResponseEntity<ResponseStructure<Orders>> getOrder(@PathVariable int orderId) {
		return orderService.getOrder(orderId);
	}

	@GetMapping(value = "/get-all-orders")
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() {
		return orderService.getAllOrders();
	}

	@DeleteMapping(value = "/{orderId}")
	public ResponseEntity<ResponseStructure<String>> deleteOrder(@PathVariable int orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	@GetMapping("/perday")
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprise(@RequestParam LocalDate date){
		return orderService.caliclatedayprice(date);
	}
	
	
}

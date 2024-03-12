package com.hotelbillapplication.hotelbillapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Operation(description = "To save order given by the customer", summary = "order  will be created")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Order sucessfull") })
	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody OrderDto orderDto) {
		return orderService.saveOrder(orderDto);
	}

	@Operation(description = "To update order given by the customer", summary = "order  will be updated")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Order updated sucessfully"),
			@ApiResponse(responseCode = "404", description = "`NOT FOUND`", content = @Content) })
	@PutMapping(value = "/{orderId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@PathVariable int orderId,
			@RequestBody OrderDto orderDto) {
		return orderService.updateOrders(orderId, orderDto);
	}

	@Operation(description = "To find the order by id", summary = "order will be displayed")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Order viewed"),
			@ApiResponse(responseCode = "404", description = "`NOT FOUND`", content = @Content) })
	@GetMapping(value = "/get-order/{orderId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> getOrder(@PathVariable int orderId) {
		return orderService.getOrder(orderId);
	}

	@Operation(description = "To view all the orders", summary = "List of orders will be displayed")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Orders viewed") })
	@GetMapping(value = "/get-all-orders", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() {
		return orderService.getAllOrders();
	}

	@Operation(description = "To cancel the order", summary = "order will be cancelled")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Orders cancled"),
			@ApiResponse(responseCode = "404", description = "`NOT FOUND`", content = @Content) })
	@DeleteMapping(value = "/{orderId}",produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteOrder(@PathVariable int orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	@Operation(description = "To caliclate total bill of the day", summary = "total bill price per day will be displayed")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Orders viewed") })
	@GetMapping(value="/perday",produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprise(@RequestParam LocalDate date) {
		return orderService.caliclatedayprice(date);
	}

}

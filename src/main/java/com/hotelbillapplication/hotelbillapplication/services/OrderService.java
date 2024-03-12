package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;

public interface OrderService {
	
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(OrderDto orderDto);
	
	public ResponseEntity<ResponseStructure<String>> deleteOrder(int order_Id);
	
	public ResponseEntity<ResponseStructure<Orders>> getOrder(int order_Id);
	
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(int order_Id,OrderDto orderDto );
	
	public ResponseEntity<ResponseStructure<List<Orders>>>  getAllOrders();

}

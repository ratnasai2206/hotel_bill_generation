package com.hotelbillapplication.hotelbillapplication.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;

public interface OrderService {

	/*
	 * it is used to save order into the Orders table
	 */
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(OrderDto orderDto);

	/*
	 * it is used to delete the particular order from orders table by using order ID
	 */
	public ResponseEntity<ResponseStructure<String>> deleteOrder(int order_Id);

	/*
	 * it is used to get particular order from orders table by using order ID
	 */
	public ResponseEntity<ResponseStructure<Orders>> getOrder(int order_Id);

	/*
	 * to update orders i.e quantity, new items and remove the item from the
	 * particular order
	 */
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(int order_Id, OrderDto orderDto);

	/*
	 * it is to display all the orders present in the order table
	 */
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders();

	/*
	 * it is used to calculate the total amount of orders in the particular day by
	 * passing the date(yyyy-mm-dd)
	 */
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprice(LocalDate date);

}

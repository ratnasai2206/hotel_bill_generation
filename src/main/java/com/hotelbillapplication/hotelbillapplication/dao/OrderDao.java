package com.hotelbillapplication.hotelbillapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.repository.OrderRepository;

@Repository
public class OrderDao {

	private OrderRepository orderRepository;

	// to save order into the database
	public Orders saveOrders(Orders orders) {
		return orderRepository.save(orders);
	}
	
	//to get order from the database
	public List<Orders> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//to get particular order from the database
	public Orders getOrder(int orderId) {
		Optional<Orders> optional= orderRepository.findById(orderId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;	
	}
	
	//to delete particular order from the database
	public boolean deleteOrderById(int orderId) {
		Optional<Orders> optional=orderRepository.findById(orderId);
		if(optional.isPresent()) {
			orderRepository.delete(optional.get());
			return true;
		}
		return false;
	}
}

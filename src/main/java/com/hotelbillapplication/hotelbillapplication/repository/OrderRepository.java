package com.hotelbillapplication.hotelbillapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	List<Orders> findBycreateOrder(LocalDate date);
}

package com.hotelbillapplication.hotelbillapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
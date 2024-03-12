package com.hotelbillapplication.hotelbillapplication.services;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;

public interface OrderService {
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprise(LocalDate date);
}

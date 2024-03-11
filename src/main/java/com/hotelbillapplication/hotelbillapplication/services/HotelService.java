package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;

public interface HotelService {

	  ResponseEntity<ResponseStructure<List<Item>>> showAllFoodItems();

}

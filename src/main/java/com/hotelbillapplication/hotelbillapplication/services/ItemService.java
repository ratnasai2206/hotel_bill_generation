package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.ItemDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;

public interface ItemService {

	  ResponseEntity<ResponseStructure<List<Item>>> showAllFoodItems();
	  ResponseEntity<ResponseStructure<Item>> saveItem(ItemDto item) ;
	  ResponseEntity<ResponseStructure<Item>> updateItem(Item item, int id);
	  ResponseEntity<ResponseStructure<String>> deleteFoodItem(int id) ;

}

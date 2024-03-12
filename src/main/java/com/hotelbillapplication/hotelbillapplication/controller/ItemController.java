package com.hotelbillapplication.hotelbillapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbillapplication.hotelbillapplication.dto.ItemDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.services.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<Item>>> getAll() {
		return itemService.showAllFoodItems();
	}

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Item>> saveFoodItem(@RequestBody ItemDto item) {
		return itemService.saveItem(item);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@PathVariable int id, @RequestBody Item items) {
		return itemService.updateItem(items, id);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItem( @PathVariable int id){
	return itemService.deleteFoodItem(id);
	}
}
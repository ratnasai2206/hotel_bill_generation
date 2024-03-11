package com.hotelbillapplication.hotelbillapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

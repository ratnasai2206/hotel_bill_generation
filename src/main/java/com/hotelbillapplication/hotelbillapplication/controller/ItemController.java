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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Operation(description = "To get Items list", summary = "Items list will be fetched from the database")
	@ApiResponses(value = { @ApiResponse(description = "Item found", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@GetMapping(value="/getAll")
	public ResponseEntity<ResponseStructure<List<Item>>> getAll() {
		return itemService.showAllFoodItems();
	}

	@Operation(description = "To Create Item info", summary = "Item will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "item Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@PostMapping(value="/")
	public ResponseEntity<ResponseStructure<Item>> saveFoodItem(@RequestBody ItemDto item) {
		return itemService.saveItem(item);
	}

	@Operation(description = "To Update item info", summary = "Item will be updated in the database")
	@ApiResponses(value = { @ApiResponse(description = "Item Updated", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@PutMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@PathVariable int itemId, @RequestBody ItemDto itemDto) {
		return itemService.updateItem(itemDto, itemId);
	}
	
	@Operation(description = "To Delete by itemId", summary = "Item will be deleted from the database")
	@ApiResponses(value = { @ApiResponse(description = "User found", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItem( @PathVariable int itemId){
	return itemService.deleteFoodItem(itemId);
	}
	
	@Operation(description = "To get Items by id", summary = "Items will be fetched from the database")
	@ApiResponses(value = { @ApiResponse(description = "Item found", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@GetMapping(value="/{itemId}")
	public ResponseEntity<ResponseStructure<Item>> getItemById(@PathVariable int itemId){
		return itemService.getItemById(itemId);
	}
	
	@Operation(description = "To get Items by Name", summary = "Items will be fetched from the database")
	@ApiResponses(value = { @ApiResponse(description = "Item found", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@GetMapping(value="/name/{itemName}")
	public ResponseEntity<ResponseStructure<Item>> getItemByName(@PathVariable String itemName){
		return itemService.getItemByName(itemName);
	}
}
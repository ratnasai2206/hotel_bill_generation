package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dto.ItemDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;

public interface ItemService {
	/*
	 * it is used to display all the items present in the items tables
	 */
	ResponseEntity<ResponseStructure<List<Item>>> showAllFoodItems();

	/*
	 * it is used to save the item in the item table
	 */
	ResponseEntity<ResponseStructure<Item>> saveItem(ItemDto item);

	/*
	 * it is used to update the particular item
	 */
	ResponseEntity<ResponseStructure<Item>> updateItem(ItemDto item, int id);

	/*
	 * it is used to delete the particular item from item table by using item ID
	 */
	ResponseEntity<ResponseStructure<String>> deleteFoodItem(int id);

	/*
	 * it is used to display the particular item from item table by using item ID
	 */
	ResponseEntity<ResponseStructure<Item>> getItemById(int itemId);

	/*
	 * it is used to display the particular item from item table by using item Name
	 */
	ResponseEntity<ResponseStructure<Item>> getItemByName(String itemName);

}

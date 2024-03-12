package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbillapplication.hotelbillapplication.dao.ItemDao;
import com.hotelbillapplication.hotelbillapplication.dto.ItemDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.exception.ItemNotFoundException;

@Service
public class ItemServices implements ItemService {

	@Autowired
	private ItemDao itemDao;

	/*
	 * it is used to display all the items present in the items tables
	 */
	@Override
	public ResponseEntity<ResponseStructure<List<Item>>> showAllFoodItems() {
		List<Item> item = itemDao.getItemList();
		ResponseStructure<List<Item>> responseStructure = new ResponseStructure<List<Item>>();
		responseStructure.setData(item);
		responseStructure.setMessage("list of items present in item table");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure, HttpStatus.OK);
	}

	/*
	 * it is used to save the item in the item table
	 */
	@Override
	public ResponseEntity<ResponseStructure<Item>> saveItem(ItemDto items) {
		Item item = new Item();
		item.setItemName(items.getItemName());
		item.setPrice(items.getPrice());

		Item receiveditems = itemDao.saveItem(item);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" item saved succesfully");
		responseStructure.setData(receiveditems);
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.CREATED);

	}

	/*
	 * it is used to update the particular item
	 */
	@Override
	public ResponseEntity<ResponseStructure<Item>> updateItem(ItemDto item, int id) {
		Item items = itemDao.getItem(id);
		if (item != null) {
			if (item.getItemName() != null) {
				items.setItemName(item.getItemName());
			}
			if (item.getPrice() != 0) {
				items.setPrice(item.getPrice());
			}
		}
		Item receivedItem = itemDao.saveItem(items);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" item data updated");
		responseStructure.setData(receivedItem);
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.CREATED);

	}

	/*
	 * it is used to delete the particular item from item table by using item ID
	 */
	@Override
	public ResponseEntity<ResponseStructure<String>> deleteFoodItem(int id) {
		boolean item = itemDao.removeItem(id);
		if (item) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(" item deleted");
			responseStructure.setData("item removed successfully");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(" item not deleted");
		responseStructure.setData("item not removed");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

	}

	/*
	 * it is used to display the particular item from item table by using item ID
	 */
	@Override
	public ResponseEntity<ResponseStructure<Item>> getItemById(int itemId) {
		Item item = itemDao.getItem(itemId);
		if (item != null) {
			ResponseStructure<Item> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(" Item found");
			responseStructure.setData(item);
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ItemNotFoundException("item not found");
		}
	}

	/*
	 * it is used to display the particular item from item table by using item Name
	 */
	@Override
	public ResponseEntity<ResponseStructure<Item>> getItemByName(String itemName) {
		Item item = itemDao.findByName(itemName);
		if (item != null) {
			ResponseStructure<Item> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(" Item found");
			responseStructure.setData(item);
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ItemNotFoundException("item not found");
		}
	}

}

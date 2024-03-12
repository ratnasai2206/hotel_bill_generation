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


@Service
public class ItemServices implements ItemService {

	@Autowired
	private ItemDao itemDao;

	// To show all food items
	public ResponseEntity<ResponseStructure<List<Item>>> showAllFoodItems() {
		List<Item> item = itemDao.getItemList();
		ResponseStructure<List<Item>> responseStructure = new ResponseStructure<List<Item>>();
		responseStructure.setData(item);
		responseStructure.setMessage("list of items present in item table");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure, HttpStatus.OK);
	}

	// To save food Item
	public ResponseEntity<ResponseStructure<Item>> saveItem(ItemDto items) {
		Item item = new Item();
		item.setItemName(items.getFood_Name());
		item.setPrice(items.getPrice());

		Item receiveditems = itemDao.saveItem(item);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" item saved succesfully");
		responseStructure.setData(receiveditems);
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.CREATED);

	}

	
	//To update food Item
	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item, int id) {
		Item items = itemDao.getItem(id);
		if (item != null) {
			if (items.getItemName() != null) {
				items.setItemName(item.getItemName());
			}
			if (item.getPrice() != 0) {
				items.setPrice(item.getPrice());
			}
		}
		Item receivedItem = itemDao.saveItem(item);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" item data updated");
		responseStructure.setData(receivedItem);
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure, HttpStatus.CREATED);

	}
	
    //To delete food item
	    public ResponseEntity<ResponseStructure<String>> deleteFoodItem(int id) {
	    	boolean item = itemDao.removeItem(id);
			if(item) {
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
	
	    }

	


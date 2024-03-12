package com.hotelbillapplication.hotelbillapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.repository.ItemRepository;

@Repository
public class ItemDao {
	

	@Autowired
	private ItemRepository itemRepository;
	
	// to save item into the database
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
	// to get a particular item from the database by using item Id
	public Item getItem(int item_Id) {
		Optional<Item> optional=itemRepository.findById(item_Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	//to get the list of items present in the database
	public List<Item> getItemList(){
		return itemRepository.findAll();
	}
	
	//to delete particular item from the database by using item Id
	public boolean removeItem(int item_Id) {
		Item item=getItem(item_Id);
		if(item !=null) {
			itemRepository.delete(item);
			return true;
		}
		return false;
	}
	
	
	
}

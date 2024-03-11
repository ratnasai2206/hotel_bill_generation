package com.hotelbillapplication.hotelbillapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.repository.HotelRepository;

@Repository
public class HotelDao {

	@Autowired
	private HotelRepository hotelRepository;
	
	// to save item into the database
	public Item saveItem(Item hotel) {
		return hotelRepository.save(hotel);
	}
	
	// to get a particular item from the database by using item Id
	public Item getItem(int item_Id) {
		Optional<Item> optional=hotelRepository.findById(item_Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	//to get the list of items present in the database
	public List<Item> getItemList(){
		return hotelRepository.findAll();
	}
	
	//to delete particular item from the database by using item Id
	public boolean removeItem(int item_Id) {
		Item hotel=getItem(item_Id);
		if(hotel !=null) {
			hotelRepository.delete(hotel);
			return true;
		}
		return false;
	}
	
}

package com.hotelbillapplication.hotelbillapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbillapplication.hotelbillapplication.dao.HotelDao;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;




@Service
public class HotelServices implements HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	public ResponseEntity<ResponseStructure<List<Item>>>showAllFoodItems() {
		List<Item> item = hotelDao.getItemList();
		ResponseStructure<List<Item>> responseStructure = new ResponseStructure();
		responseStructure.setData(item);
		responseStructure.setMessage("list of items present in item table");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure, HttpStatus.OK);
	}

}

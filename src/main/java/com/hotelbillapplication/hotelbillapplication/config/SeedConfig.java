package com.hotelbillapplication.hotelbillapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.hotelbillapplication.hotelbillapplication.entity.Hotel;
import com.hotelbillapplication.hotelbillapplication.repository.HotelRepository;

public class SeedConfig implements CommandLineRunner {

	@Autowired
	private HotelRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		if(repository.count()==0) {
			Hotel hotel =new Hotel();
			hotel.setFood_Name("Full meals");
			hotel.setPrice(150);
			repository.save(hotel);
			
		}
		
	}

}

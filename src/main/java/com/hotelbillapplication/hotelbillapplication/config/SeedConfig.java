package com.hotelbillapplication.hotelbillapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.repository.ItemRepository;

public class SeedConfig implements CommandLineRunner {

	@Autowired
	private ItemRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		if(repository.count()==0) {
			Item hotel =new Item();
			hotel.setFood_Name("Full meals");
			hotel.setPrice(150);
			repository.save(hotel);
			
		}
		
	}

}

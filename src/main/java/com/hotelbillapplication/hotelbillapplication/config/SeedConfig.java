package com.hotelbillapplication.hotelbillapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.repository.ItemRepository;

@Configuration
public class SeedConfig implements CommandLineRunner {

	@Autowired
	private ItemRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		if(repository.count()==0) {
			Item item =new Item();
			item.setItemName("Full Meals");
			item.setPrice(150);
			repository.save(item);
		}
		
	}

}

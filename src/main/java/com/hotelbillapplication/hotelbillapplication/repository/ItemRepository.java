package com.hotelbillapplication.hotelbillapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Item;




public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	Item findByItemName(String name);
}	


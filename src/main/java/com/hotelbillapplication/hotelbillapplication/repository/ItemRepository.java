package com.hotelbillapplication.hotelbillapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	/*
	 * it is used to display particular item by using the item Name
	 */
	Item findByItemName(String name);
}

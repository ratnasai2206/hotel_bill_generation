package com.hotelbillapplication.hotelbillapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Item;

public interface HotelRepository extends JpaRepository<Item, Integer> {

}

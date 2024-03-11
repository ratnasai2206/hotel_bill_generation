package com.hotelbillapplication.hotelbillapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbillapplication.hotelbillapplication.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}

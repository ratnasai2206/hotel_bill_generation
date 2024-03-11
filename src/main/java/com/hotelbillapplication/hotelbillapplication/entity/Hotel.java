package com.hotelbillapplication.hotelbillapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "hotel_id")
	@SequenceGenerator(name = "hotel_id", initialValue = 1, allocationSize = 1, sequenceName = "hotel_sequence")
	private int itemId;
	private String food_Name;
	private double price;

}

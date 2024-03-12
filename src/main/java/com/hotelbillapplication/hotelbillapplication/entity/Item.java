package com.hotelbillapplication.hotelbillapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "hotel_id")
	@SequenceGenerator(name = "hotel_id", initialValue = 1, allocationSize = 1, sequenceName = "hotel_sequence")
	private int itemId;
	@Column(unique = true)
	private String itemName;
	private double price;

}

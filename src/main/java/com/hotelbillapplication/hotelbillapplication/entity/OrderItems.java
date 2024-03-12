package com.hotelbillapplication.hotelbillapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orders_id")
	@SequenceGenerator(name = "orders_id", initialValue = 10001, allocationSize = 1, sequenceName = "order_sequence")
	private int orderItemId;
	private String itemName;
	private int quantity;
}

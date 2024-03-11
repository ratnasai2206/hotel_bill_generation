package com.hotelbillapplication.hotelbillapplication.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItems {

	private String itemName;
	private int quantity;
}

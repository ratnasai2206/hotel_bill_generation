package com.hotelbillapplication.hotelbillapplication.dto;

import java.util.List;

import com.hotelbillapplication.hotelbillapplication.entity.OrderItems;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderDto {

	
	private List<OrderItems> items;
	private double totalPrice;
}

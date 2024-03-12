package com.hotelbillapplication.hotelbillapplication.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_id")
	@SequenceGenerator(name = "order_id", initialValue = 1001, allocationSize = 1, sequenceName = "order_sequence")
	private int orderId;
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderItems> items;
	@CurrentTimestamp
	private LocalDate createOrder;
	private double totalPrice;
	
}

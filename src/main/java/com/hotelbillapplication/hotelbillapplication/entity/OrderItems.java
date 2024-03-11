package com.hotelbillapplication.hotelbillapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItems {

	private String itemName;
	private int quantity;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Orders order;
}

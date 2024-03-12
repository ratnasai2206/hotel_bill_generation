package com.hotelbillapplication.hotelbillapplication.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotelbillapplication.hotelbillapplication.dao.ItemDao;
import com.hotelbillapplication.hotelbillapplication.dao.OrderDao;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.entity.OrderItems;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.exception.ItemNotFoundException;


import org.springframework.stereotype.Service;

@Service

public class OrderServices implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprise(LocalDate date) {
		List<Orders> ordersInDay=orderDao.findByDate(date);
		double prise=0;
		for(Orders order:ordersInDay) {
				List<OrderItems> items=order.getItems();
				for(OrderItems item:items) {
					Item orderedItem=itemDao.findByName(item.getItemName());
					prise+=orderedItem.getPrice()*item.getQuantity();
				}
			
		}
		ResponseStructure<Double> responseStructure=new ResponseStructure<Double>();
		responseStructure.setData(prise);
		responseStructure.setMessage("Sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Double>>(responseStructure,HttpStatus.OK);
	}
	
	public double caliclateTotalPrise(Orders orders){
		double prise=0;
		if(orders!=null) {
			List<OrderItems> items=orders.getItems();
			for(OrderItems item:items) {
				Item orderedItem=itemDao.findByName(item.getItemName());
				if(item!=null) {
					prise+=orderedItem.getPrice()*item.getQuantity();
				}
				else {
					throw new ItemNotFoundException("Item Not Found");
				}
				
			}
		}
		ResponseStructure<Double> responseStructure=new ResponseStructure<Double>();
		responseStructure.setData(prise);
		responseStructure.setMessage("Sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return prise;
	}

}

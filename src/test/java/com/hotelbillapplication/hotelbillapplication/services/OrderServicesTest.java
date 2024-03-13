package com.hotelbillapplication.hotelbillapplication.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbillapplication.hotelbillapplication.HotelBillApplication;
import com.hotelbillapplication.hotelbillapplication.dao.ItemDao;
import com.hotelbillapplication.hotelbillapplication.dao.OrderDao;
import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.entity.OrderItems;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.repository.OrderRepository;

import jakarta.transaction.Transactional;

@SpringBootTest(classes = HotelBillApplication.class)
@Transactional
class OrderServicesTest {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private OrderRepository orderRepository;
	
	@Disabled
	@Test
	public void caliclatedayPrise() {
		LocalDate date=LocalDate.of(2024, 3, 12);
		List<Orders> ordersInDay = orderDao.findByDate(date);
		double price = 0;
		for (Orders order : ordersInDay) {
			System.out.println(order);
			List<OrderItems> items = order.getItems();
			System.out.println(items);
			for (OrderItems item : items) {
				Item orderedItem = itemDao.findByName(item.getItemName());
				price += orderedItem.getPrice() * item.getQuantity();
			}

		}
		assertEquals(price, 1800);
		
	}
	
	
	@Test
	public void caliclatePrise() {
		Optional<Orders> opt=orderRepository.findById(10008);
		double price = 0;
		if(opt.isPresent()) {
			Orders order=opt.get();
			List<OrderItems> items = order.getItems();
			for (OrderItems item : items) {
				System.out.println(item.getItemName());
				Item orderedItem = itemDao.findByName(item.getItemName());
				System.out.println(orderedItem);

					price += orderedItem.getPrice() * item.getQuantity();
					
					
			}
			assertEquals(1200,price);
		}
	}
}

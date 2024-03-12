 package com.hotelbillapplication.hotelbillapplication.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbillapplication.hotelbillapplication.dao.ItemDao;
import com.hotelbillapplication.hotelbillapplication.dao.OrderDao;
import com.hotelbillapplication.hotelbillapplication.dto.OrderDto;
import com.hotelbillapplication.hotelbillapplication.dto.ResponseStructure;
import com.hotelbillapplication.hotelbillapplication.entity.Item;
import com.hotelbillapplication.hotelbillapplication.entity.OrderItems;
import com.hotelbillapplication.hotelbillapplication.entity.Orders;
import com.hotelbillapplication.hotelbillapplication.exception.ItemNotFoundException;
import com.hotelbillapplication.hotelbillapplication.exception.OrderNotFoundException;
import com.hotelbillapplication.hotelbillapplication.exception.OrdersNotSaveException;

@Service

public class OrderServices implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Double>> caliclatedayprice(LocalDate date) {
		List<Orders> ordersInDay=orderDao.findByDate(date);
		double price=0;
		for(Orders order:ordersInDay) {
				List<OrderItems> items=order.getItems();
				for(OrderItems item:items) {
					Item orderedItem=itemDao.findByName(item.getItemName());
					price+=orderedItem.getPrice()*item.getQuantity();
				}
			
		}
		ResponseStructure<Double> responseStructure=new ResponseStructure<Double>();
		responseStructure.setData(price);
		responseStructure.setMessage("Sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Double>>(responseStructure,HttpStatus.OK);
	}
	
	public double caliclateTotalPrice(Orders orders){
		double price=0;
		if(orders!=null) {
			List<OrderItems> items=orders.getItems();
			for(OrderItems item:items) {
				System.out.println(item.getItemName());
				Item orderedItem=itemDao.findByName(item.getItemName());
				System.out.println(orderedItem);
				
				if(orderedItem!=null) {
					price+=orderedItem.getPrice()*item.getQuantity();
				}
				else {
					throw new ItemNotFoundException("Item Not Found");
				}
					
				
			}
		}
		else {
			throw new OrderNotFoundException("Order Nott Found");
		}
		
		return price;
	}

	
	@Override
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(OrderDto orderDto) {
		if(orderDto!=null) {
		Orders order=new Orders();
		
		order.setItems(orderDto.getItems());
		order.setTotalPrice(caliclateTotalPrice(order));
		Orders recivedOrder=orderDao.saveOrders(order);
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("order created successfully");
		structure.setData(recivedOrder);
		return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.CREATED);
		}
		throw new OrdersNotSaveException();
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteOrder(int order_Id) {
		Orders orders=orderDao.getOrder(order_Id);
		if(orders!=null) {
			boolean str=orderDao.deleteOrderById(order_Id);
			if(str) {
				ResponseStructure<String> structure = new ResponseStructure<String>();
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setMessage("Ok");
				structure.setData("Successfully Deleted");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			}else {
				ResponseStructure<String> structure = new ResponseStructure<String>();
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setMessage("Ok");
				structure.setData("their is a conflict to delete the order");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			}
		}
		throw new OrderNotFoundException("Order Not Found By This Order ID" +order_Id);
	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> getOrder(int order_Id) {
		Orders orders = orderDao.getOrder(order_Id);
		if (orders != null) {
			ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(orders);
			return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.OK);
		}
		throw new OrderNotFoundException("Order Not Found By This Order ID" +order_Id);
	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(int order_Id, OrderDto orderDto) {
	    Orders order = orderDao.getOrder(order_Id); 
	    if (orderDto != null && order != null) {
	        // Merge items from the DTO into the existing order
	        List<OrderItems> existingItems = order.getItems();
	        List<OrderItems> updatedItems = orderDto.getItems();
//	        existingItems.addAll(updatedItems);
	        // Update or add new items
	        for (OrderItems updatedItem : updatedItems) {
	            boolean itemExists = false;
	            for (OrderItems existingItem : existingItems) {
	                if (existingItem.getItemName().equalsIgnoreCase(updatedItem.getItemName())) {
	                    // Item exists, update its quantity
	                    existingItem.setQuantity(updatedItem.getQuantity());
	                    itemExists = true;
	                    break;
	                }
	            }
	            // If item doesn't exist in the original order, add it
	            if (!itemExists) {
	                existingItems.add(updatedItem);
	            }
	        }

	        // Remove items that are not present in the updated list
	        existingItems.removeIf(existingItem ->
	                updatedItems.stream().noneMatch(updatedItem ->
	                existingItem.getItemName().equalsIgnoreCase(updatedItem.getItemName())));

	        order.setItems(existingItems);
	        order.setTotalPrice(caliclateTotalPrice(order));
	        
	        Orders receivedOrders = orderDao.saveOrders(order);
	        
	        ResponseStructure<Orders> structure = new ResponseStructure<>();
	        structure.setStatusCode(HttpStatus.OK.value());
	        structure.setMessage("Ok");
	        structure.setData(receivedOrders);
	        
	        return new ResponseEntity<>(structure, HttpStatus.OK);    
	    }
	    throw new OrderNotFoundException("Order Not Found By This Order ID " + order_Id);
	}

	

	@Override
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() {
		List<Orders> orders=orderDao.getAllOrders();
		ResponseStructure<List<Orders>> structure = new ResponseStructure<List<Orders>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Ok");
		structure.setData(orders);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure, HttpStatus.OK);
	}


	

}


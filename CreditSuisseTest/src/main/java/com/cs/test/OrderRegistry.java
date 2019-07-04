package com.cs.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.test.IOrder.OrderType;

@Component
public class OrderRegistry implements IOrderRegistry {

	@Autowired
	LedgerPrinter printer;
	
	private Map<Float, Float> buyOrders = new HashMap<Float, Float>();
	private Map<Float, Float> sellOrders = new HashMap<Float, Float>();

	public void addOrder(OrderDTO orderDTO) {
		if (orderDTO.getOrderType() == OrderType.BUY) {
			if (buyOrders.computeIfPresent(orderDTO.getPrice(), (k, v) ->  v + orderDTO.getQuantity()) == null) {
				buyOrders.put(orderDTO.getPrice(), orderDTO.getQuantity());
			}			
		}
		else 
		{
			if (sellOrders.computeIfPresent(orderDTO.getPrice(), (k, v) ->  v + orderDTO.getQuantity()) == null) {
				sellOrders.put(orderDTO.getPrice(), orderDTO.getQuantity());
			}
		}
		printer.print(this);
	}
	
	public void deleteOrder(OrderDTO orderDTO) {
		Float quantity;
		
		if (orderDTO.getOrderType() == OrderType.BUY) {
			if((quantity = buyOrders.get(orderDTO.getPrice())) != null) {
				quantity -= orderDTO.getQuantity();
				
				if (quantity > 0) 
					buyOrders.put(orderDTO.getPrice(), quantity);
				else
					buyOrders.remove(orderDTO.getPrice());
			}
		}
		else
		{
			if((quantity = sellOrders.get(orderDTO.getPrice())) != null) {
				quantity -= orderDTO.getQuantity();
				if (quantity > 0) 
					sellOrders.put(orderDTO.getPrice(), quantity);
				else
					sellOrders.remove(orderDTO.getPrice());
			}
		}
		printer.print(this);
	}
	
	public Map<Float, Float> getBuyOrders() {
		return buyOrders;
	}

	public Map<Float, Float> getSellOrders() {
		return sellOrders;
	}
}
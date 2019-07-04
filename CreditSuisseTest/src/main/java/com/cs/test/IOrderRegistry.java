package com.cs.test;

import java.util.Map;

public interface IOrderRegistry {

	public void addOrder(OrderDTO orderDTO);
	public void deleteOrder(OrderDTO orderDTO);
	public Map<Float, Float> getSellOrders();
	public Map<Float, Float> getBuyOrders();
}

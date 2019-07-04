package com.cs.test;

import com.cs.test.IOrder.OrderType;

public class OrderDTO {

	private String userId; 
	private float quantity; 
	private float price;
	private OrderType orderType;
	
	public OrderDTO(String userId, float quantity, float price, String orderType) {
		super();
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
		if (orderType == "BUY")
		{
			this.orderType = OrderType.BUY;
		}
		else if (orderType == "SELL") {
			this.orderType = OrderType.SELL;
		}
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

}

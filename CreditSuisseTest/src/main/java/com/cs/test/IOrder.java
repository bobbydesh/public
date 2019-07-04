package com.cs.test;

public interface IOrder {
	
	public enum OrderType {BUY, SELL};
	
	public boolean registerOrder(String userId, float quantity, float price, OrderType orderType);

}

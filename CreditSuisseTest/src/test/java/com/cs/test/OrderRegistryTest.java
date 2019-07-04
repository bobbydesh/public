package com.cs.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderRegistry.class, LedgerPrinter.class})
public class OrderRegistryTest {
	
	@Autowired
	IOrderRegistry orderRegistry;

	@Test
	public void testAddOrder() {
		float f = 322.0f;
		orderRegistry.addOrder(new OrderDTO("User1",233.2f,f,"BUY"));
		orderRegistry.addOrder(new OrderDTO("User1",233.2f,f,"BUY"));
		orderRegistry.addOrder(new OrderDTO("User1",233.2f,f,"BUY"));
		orderRegistry.addOrder(new OrderDTO("User1",233.2f,f,"BUY"));
		assertEquals(orderRegistry.getBuyOrders().size(), 1);
		assertEquals(Float.valueOf(34543.0f), orderRegistry.getBuyOrders().get(f));
	}
	
	@Test
	public void testDeleteOrder() {	
		orderRegistry = new OrderRegistry();
	}
}

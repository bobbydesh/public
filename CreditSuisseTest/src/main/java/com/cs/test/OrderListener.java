package com.cs.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@ComponentScan("com.cs.test")
public class OrderListener {

	@Autowired
	IOrderRegistry orderRegistry;
	
	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public String createOrder(@RequestBody OrderRequest request) {
		OrderDTO orderDTO = new OrderDTO(request.getUserId(), request.getQuantity(), request.getPrice(), request.getOrderType());
		orderRegistry.addOrder(orderDTO);
		return "Success";
		
	}
	
	@RequestMapping(value = "/deleteorder", method = RequestMethod.POST)
	public String deleteOrder(@RequestBody OrderRequest request) {
		OrderDTO orderDTO = new OrderDTO(request.getUserId(), request.getQuantity(), request.getPrice(), request.getOrderType());
		orderRegistry.deleteOrder(orderDTO);
		return "Success";
		
	}
}

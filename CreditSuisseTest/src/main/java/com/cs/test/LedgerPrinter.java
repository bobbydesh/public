package com.cs.test;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LedgerPrinter {

	public void print(OrderRegistry orderRegistry) {
		orderRegistry.getBuyOrders().entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));
		orderRegistry.getSellOrders().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));
	}

}

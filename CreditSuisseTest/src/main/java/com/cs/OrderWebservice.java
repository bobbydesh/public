package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs.test.OrderListener;

@SpringBootApplication
public class OrderWebservice {

	public static void main(String[] args)
	{
		SpringApplication.run(OrderListener.class, args);
	}
}

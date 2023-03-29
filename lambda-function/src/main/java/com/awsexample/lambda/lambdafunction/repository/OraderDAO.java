package com.awsexample.lambda.lambdafunction.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.awsexample.lambda.lambdafunction.domain.Order;

@Repository
public class OraderDAO {
	
	public List<Order> buildOrders() {
		
		return Stream.of(
				new Order(101, "mobile",  20000, 1),
				new Order(102, "book", 250, 2),
				new Order(278, "book",300, 1),
				new Order(953, "jeans", 2500, 1)				
				).collect(Collectors.toList());
		
	}
}

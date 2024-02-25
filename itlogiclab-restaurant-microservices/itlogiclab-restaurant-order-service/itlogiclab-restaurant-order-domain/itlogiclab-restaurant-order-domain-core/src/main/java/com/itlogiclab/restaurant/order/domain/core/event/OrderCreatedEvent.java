package com.itlogiclab.restaurant.order.domain.core.event;

import java.time.ZonedDateTime;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;

public class OrderCreatedEvent extends OrderEvent {
	public OrderCreatedEvent(Order order, ZonedDateTime createdAt) {
		super(order, createdAt);
	}
}

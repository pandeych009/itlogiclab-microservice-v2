package com.itlogiclab.restaurant.order.domain.core.event;

import java.time.ZonedDateTime;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;

public abstract class OrderEvent implements DomainEvent<Order> {

	private Order order; 
	private ZonedDateTime createdAt;
	public OrderEvent(Order order, ZonedDateTime createdAt) {
		super();
		this.order = order;
		this.createdAt = createdAt;
	}
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @return the createdAt
	 */
	public ZonedDateTime getCreatedAt() {
		return createdAt;
	} 
}

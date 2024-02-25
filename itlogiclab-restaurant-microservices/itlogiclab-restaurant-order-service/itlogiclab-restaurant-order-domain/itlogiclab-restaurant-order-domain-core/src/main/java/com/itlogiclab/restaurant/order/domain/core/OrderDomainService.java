package com.itlogiclab.restaurant.order.domain.core;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;

public interface OrderDomainService {

	public void approvedOrder(Order order);
	
	public void cancelOrder(Order order);
	
}

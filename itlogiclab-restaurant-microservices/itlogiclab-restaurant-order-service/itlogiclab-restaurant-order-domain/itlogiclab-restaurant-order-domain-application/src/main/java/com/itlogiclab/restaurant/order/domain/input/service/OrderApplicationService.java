package com.itlogiclab.restaurant.order.domain.input.service;

import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderResponse;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderQuery;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderResponse;

public interface OrderApplicationService {
	
	public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand); 
	
	public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery);

}

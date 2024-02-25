package com.itlogiclab.restaurant.order.domain;

import org.springframework.stereotype.Service;

import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderResponse;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderQuery;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderResponse;
import com.itlogiclab.restaurant.order.domain.input.service.OrderApplicationService;

@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {

	private final  OrderCreateCommandHandler  orderCreateCommandHandler;  
	
	public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler) {
		super();
		this.orderCreateCommandHandler = orderCreateCommandHandler;
	}

	@Override
	public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
		// TODO Auto-generated method stub
		return orderCreateCommandHandler.saveOrder(createOrderCommand);
	}

	@Override
	public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
		// TODO Auto-generated method stub
		return orderCreateCommandHandler.trackOrder(trackOrderQuery.getOrderTrackingId());
	}

}

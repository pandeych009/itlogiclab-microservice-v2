package com.itlogiclab.restaurant.order.domain;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.event.OrderEvent;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderResponse;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderResponse;

@Component
public class OrderCreateCommandHandler {
	private static final Logger LOG = LoggerFactory.getLogger(OrderCreateCommandHandler.class); 
	
	private final OrderCreateHelper 		orderCreateHelper;
	private final OrderDataMapper			orderDataMapper; 
	
	
	public OrderCreateCommandHandler(OrderDataMapper orderDataMapper, OrderCreateHelper orderCreateHelper) {
		super();
		this.orderCreateHelper 			= orderCreateHelper;
		this.orderDataMapper 			= orderDataMapper;
	}


	public CreateOrderResponse saveOrder(CreateOrderCommand createOrderCommand) {
		LOG.info("OrderCreateCommandHandler: Initiate to Create Order");
		OrderEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
		CreateOrderResponse response = orderDataMapper.orderToCreateOrderResposne(orderCreatedEvent.getOrder());
		LOG.info("Returning CreateOrderResponse with order id: {}", orderCreatedEvent.getOrder().getId());
		return response;
	}
	
	public TrackOrderResponse trackOrder(UUID trackingId) {
		LOG.info("OrderCreateCommandHandler: Tracking the order with tracking id: {}", trackingId);
		Order persistedOrder = orderCreateHelper.trackOrderByTrackingId(trackingId);
		LOG.info("Returning TrackOrderResponse with order id: {}", persistedOrder.getId().getValue());

		return TrackOrderResponse
			.builder()
			.withOrder(persistedOrder)
			.withOrderStatus(persistedOrder.getOrderStatus())
			.withTrackingId(persistedOrder.getTrackingId().getValue())
			.build();
	}
}

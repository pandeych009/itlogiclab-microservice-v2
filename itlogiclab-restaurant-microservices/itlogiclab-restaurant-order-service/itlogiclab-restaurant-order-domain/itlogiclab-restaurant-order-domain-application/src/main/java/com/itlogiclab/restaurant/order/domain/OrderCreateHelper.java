package com.itlogiclab.restaurant.order.domain;

import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.event.OrderCreatedEvent;
import com.itlogiclab.restaurant.order.domain.core.exception.DomainException;
import com.itlogiclab.restaurant.order.domain.core.utils.DomainApplicationUtils;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.output.reopsitory.OrderRepository;

@Component
public class OrderCreateHelper {
	private static final Logger LOG = LoggerFactory.getLogger(OrderCreateHelper.class);
	
	private final OrderRepository    orderRepository;
	private final OrderDataMapper    orderDataMapper; 

	public OrderCreateHelper(OrderRepository orderRepository, OrderDataMapper orderDataMapper) {
		super();
		this.orderRepository 	= orderRepository;
		this.orderDataMapper 	= orderDataMapper;
	} 

	
	public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
		LOG.info("Persisting order to the database with id: {}", createOrderCommand);
		Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
		Order persistedOrder =  saveOrder(order);
		return new OrderCreatedEvent(persistedOrder, DomainApplicationUtils.CURRENT_DATE);
	}
	
	
	private Order saveOrder(Order order) {
		Order persistedOrder = orderRepository.save(order);
		if(Objects.isNull(persistedOrder)) {
			LOG.error("Order is failed to save");
			throw new DomainException("Could not save the order !");
		}
		
		LOG.info("Order is persisted with the order Id in database: {}", persistedOrder.getId().getValue());
		return persistedOrder;
	}
	
	
	public Order trackOrderByTrackingId(UUID trackingId) {
		Order persistedOrder = orderRepository.findByTrackingId(new TrackingId(trackingId));
		LOG.info("Order is present with the tracking Id in database: {}", persistedOrder.getTrackingId());
		return persistedOrder;
	}

	public Order findById(Long orderId) {
		Order persistedOrder = orderRepository.findById(new OrderId(orderId));
		LOG.info("Order is present with the order Id in database: {}", persistedOrder.getId());
		return persistedOrder;
	}
	
}

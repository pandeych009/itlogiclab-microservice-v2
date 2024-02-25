package com.itlogiclab.restaurant.order.dataaccess.adaptor;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.restaurant.order.dataaccess.exception.OrderNotFoundException;
import com.itlogiclab.restaurant.order.dataaccess.mapper.OrderDataAccessMapper;
import com.itlogiclab.restaurant.order.dataaccess.repository.OrderJPARepository;
import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;
import com.itlogiclab.restaurant.order.domain.output.reopsitory.OrderRepository;

import jakarta.transaction.Transactional;
@Component

public class OrderRepositoryImpl implements OrderRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderRepositoryImpl.class);
	
	private final OrderJPARepository 	orderJPARepository; 
	private final OrderDataAccessMapper orderDataAccessMapper;

	public OrderRepositoryImpl(OrderJPARepository orderJPARepository, OrderDataAccessMapper orderDataAccessMapper) {
		super();
		this.orderJPARepository = orderJPARepository;
		this.orderDataAccessMapper = orderDataAccessMapper;
	}

	@Override
	@Transactional
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderDataAccessMapper.orderEntityToOrder(orderJPARepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
	}

	@Override
	public Order findByTrackingId(TrackingId trackingId) {
		// TODO Auto-generated method stub
		Optional<Order> persistedOrder = orderJPARepository.findByTrackingId(trackingId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
		return persistedOrder.orElseThrow(OrderNotFoundException::new);
	}

	@Override
	public Order findById(OrderId orderId) {
		// TODO Auto-generated method stub
		Optional<Order> persistedOrder = orderJPARepository.findById(orderId.getValue()).map(orderDataAccessMapper::orderEntityToOrder); 
		return persistedOrder.orElseThrow(OrderNotFoundException::new);
	}

}

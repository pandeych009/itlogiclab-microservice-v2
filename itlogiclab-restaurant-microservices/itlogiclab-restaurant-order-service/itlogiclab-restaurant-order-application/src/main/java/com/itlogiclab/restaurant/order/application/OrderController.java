package com.itlogiclab.restaurant.order.application;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderResponse;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderQuery;
import com.itlogiclab.restaurant.order.domain.dto.query.TrackOrderResponse;
import com.itlogiclab.restaurant.order.domain.input.service.OrderApplicationService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/order" , consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	private static Logger LOG = LoggerFactory.getLogger(OrderController.class) ;
	
	private final OrderApplicationService applicationService;

	@Autowired
	public OrderController(OrderApplicationService applicationService) {
		this.applicationService = applicationService;
	} 

	@PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
		// TODO Auto-generated method stub
		LOG.info("OrderController: cretate : Creating order for Customer: {} at restaurant: {}", createOrderCommand.getCustomerId(), createOrderCommand.getRestaurantId());
		CreateOrderResponse createOrderResponse = applicationService.createOrder(createOrderCommand);
		LOG.info("OrderController: cretate : Order created with the tracking id {}", createOrderResponse.getTrackingId() );
		return ResponseEntity.ok(createOrderResponse);
	}

	@GetMapping(value = "/get/{trackingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrackOrderResponse> getOrderByTrackingId(@PathVariable UUID trackingId) {
		// TODO Auto-generated method stub
		TrackOrderResponse response = null;
		try {
		response = applicationService.trackOrder(TrackOrderQuery.builder().withOrderTrackingId(trackingId).build());
		LOG.info("OrderController: get: Returning order status woth the tracking id: {}", response.getTrackingId());
		}catch (Exception e) {
			LOG.error("Error occured while fetching order with id {} from DB: ",trackingId +e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		return ResponseEntity.ok(response);
	}
	
	
}

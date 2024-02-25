package com.itlogiclab.restaurant.order.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.entity.OrderAddress;
import com.itlogiclab.restaurant.order.domain.core.entity.OrderItem;
import com.itlogiclab.restaurant.order.domain.core.entity.Product;
import com.itlogiclab.restaurant.order.domain.core.valueobject.CustomerId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.Money;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderStatus;
import com.itlogiclab.restaurant.order.domain.core.valueobject.ProductId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.RestaurantId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderAddressCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderItemCommand;
import com.itlogiclab.restaurant.order.domain.dto.commands.CreateOrderResponse;

@Component
public class OrderDataMapper {

	public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
		return Order
				.builder()
				.withCustomerId(new CustomerId(createOrderCommand.getCustomerId()))
				.withRestaurantId(new RestaurantId(createOrderCommand.getRestaurantId()) )
				.withOrderStatus(OrderStatus.PENDING)
				.withItems(createOrderItemsCommandToOrderItems(createOrderCommand.getItems()))
				.withOrderAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
				.withPrice(new Money(createOrderCommand.getPrice()))
				.withTrackingId(new TrackingId(UUID.randomUUID()))
				.build();
	}
	
	public OrderItem createOrderItemCommandToOrderItem(CreateOrderItemCommand createOrderItemCommand ) {
		return OrderItem
				.builder()
				.withItemPrice(new Money(createOrderItemCommand.getPrice()))
				.withProduct(new Product(new ProductId(createOrderItemCommand.getProductId())))
				.withQuantity(createOrderItemCommand.getQuantity())
				.build();
	}
	
	public List<OrderItem> createOrderItemsCommandToOrderItems(List<CreateOrderItemCommand> createOrderItemCommands ){
		return createOrderItemCommands.stream().map(input -> createOrderItemCommandToOrderItem(input)).collect(Collectors.toList());		
	}
	
	public CreateOrderResponse orderToCreateOrderResposne(final Order order) {
		return CreateOrderResponse
				.builder()
				.withTrackingId(order.getTrackingId().getValue())
				.build();
	}
	
	public OrderAddress orderAddressToStreetAddress(CreateOrderAddressCommand address) {
		return OrderAddress
				.builder()
				.withLine1(address.getLine1())
				.withLine1(address.getLine2())
				.withCity(address.getCity())
				.withState(address.getState())
				.withCountry(address.getCountry())
				.build();

	}
	
}

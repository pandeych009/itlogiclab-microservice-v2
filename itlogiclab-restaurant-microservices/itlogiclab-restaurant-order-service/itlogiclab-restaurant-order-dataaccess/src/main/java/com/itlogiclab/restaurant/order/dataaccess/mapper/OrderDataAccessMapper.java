package com.itlogiclab.restaurant.order.dataaccess.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itlogiclab.restaurant.order.dataaccess.entity.OrderAddressEntity;
import com.itlogiclab.restaurant.order.dataaccess.entity.OrderEntity;
import com.itlogiclab.restaurant.order.dataaccess.entity.OrderItemEntity;
import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.entity.OrderAddress;
import com.itlogiclab.restaurant.order.domain.core.entity.OrderItem;
import com.itlogiclab.restaurant.order.domain.core.entity.Product;
import com.itlogiclab.restaurant.order.domain.core.valueobject.CustomerId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.Money;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderItemId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.ProductId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.RestaurantId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;

@Component
public class OrderDataAccessMapper {
	
	public OrderEntity orderToOrderEntity(Order order) {
		OrderEntity orderEntity =  OrderEntity
				.builder()
				.withCustomerId(order.getCustomerId().getValue())
				.withOrderId(Objects.nonNull(order.getId()) ? order.getId().getValue() : null)
				.withRestaurantId(order.getRestaurantId().getValue())
				.withPrice(order.getPrice().getAmount())
				.withTrackingId(order.getTrackingId().getValue())
				.withStatus(order.getOrderStatus())
				.withAddress(addressToAddressEntity(order.getDeliveryAddress()))
				.withItems(orderItemsToOrderItemEntityList(order.getItems()))
				.build();
		
		orderEntity.getAddress().setOrder(orderEntity);
		orderEntity.getItems().forEach(item -> item.setOrder(orderEntity));
		
		return orderEntity;
	}
	
	
	public OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem) {
		return OrderItemEntity
				.builder()
				.withId(Objects.nonNull(orderItem.getId()) ? orderItem.getId().getValue() : null)
				.withPrice(orderItem.getItemPrice().getAmount())
				.withProductId(orderItem.getProduct().getId().getValue())
				.withQuantity(orderItem.getQuantity())
				.build();
	}
	
	public List<OrderItemEntity> orderItemsToOrderItemEntityList(List<OrderItem> orderItems){
		return orderItems.stream().map(orderItem -> orderItemToOrderItemEntity(orderItem)).collect(Collectors.toList());
	}
	
	public OrderAddressEntity addressToAddressEntity(OrderAddress address) {
		return OrderAddressEntity
				.builder()
				.withId(address.getId())
				.withLine1(address.getLine1())
				.withLine2(address.getLine2())
				.withCity(address.getCity())
				.withState(address.getState())
				.withCountry(address.getCountry())
				.build();
	}
	
	public Order orderEntityToOrder(OrderEntity entity) {
		return Order
				.builder()
				.withCustomerId(new CustomerId(entity.getCustomerId()))
				.withPrice(new Money(entity.getPrice()))
				.withRestaurantId(new RestaurantId(entity.getRestaurantId()))
				.withOrderStatus(entity.getStatus())
				.withTrackingId(new TrackingId(entity.getTrackingId()))
				.orderId(new OrderId(entity.getOrderId()))
				.withItems(orderItemEntitiesToOrderItems(entity.getItems()))
				.withOrderAddress(orderAddressEntityToOrderAddress(entity.getAddress()))
				.build();
	}
	
	
	private List<OrderItem> orderItemEntitiesToOrderItems(List<OrderItemEntity> items) {
		return items.stream()
				.map(orderItemEntity -> orderItemEntityToOrderItem(orderItemEntity))
				.collect(Collectors.toList());
	}
	
	private OrderItem orderItemEntityToOrderItem(OrderItemEntity orderItemEntity) {
		return OrderItem.builder()
		.withOrderItemId(new OrderItemId(orderItemEntity.getId()))
		.withProduct(new Product(new ProductId(orderItemEntity.getProductId())))
		.withItemPrice(new Money(orderItemEntity.getPrice()))
		.withQuantity(orderItemEntity.getQuantity())
		.build();
	}
	
	private OrderAddress orderAddressEntityToOrderAddress(OrderAddressEntity addressEntity) {
		return OrderAddress
				.builder()
				.withId(addressEntity.getId())
				.withLine1(addressEntity.getLine1())
				.withLine2(addressEntity.getLine2())
				.withCity(addressEntity.getCity())
				.withState(addressEntity.getState())
				.withCountry(addressEntity.getCountry())
				.build();
	}

}

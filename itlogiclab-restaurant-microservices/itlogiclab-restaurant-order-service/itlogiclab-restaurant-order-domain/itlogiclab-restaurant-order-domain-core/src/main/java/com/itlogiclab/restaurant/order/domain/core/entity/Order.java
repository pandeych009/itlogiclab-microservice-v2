package com.itlogiclab.restaurant.order.domain.core.entity;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itlogiclab.restaurant.order.domain.core.exception.DomainException;
import com.itlogiclab.restaurant.order.domain.core.valueobject.CustomerId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.Money;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderStatus;
import com.itlogiclab.restaurant.order.domain.core.valueobject.RestaurantId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;

public class Order extends AggregateRoot<OrderId>{
	
	private static final Logger LOG = LoggerFactory.getLogger(Order.class);
	
	private final CustomerId 		customerId; 
	private final RestaurantId		restaurantId; 
	private final List<OrderItem> 	items;
	private final Money				price; 
	private TrackingId 				trackingId;
	
	private OrderStatus 			orderStatus;
	private final OrderAddress 		deliveryAddress;

	private Order(Builder builder) {
		setId(builder.orderId);
		this.customerId 		= builder.customerId;
		this.restaurantId 		= builder.restaurantId;
		this.items 				= builder.items;
		this.price 				= builder.price;
		this.trackingId 		= builder.trackingId;
		this.orderStatus 		= builder.orderStatus;
		this.deliveryAddress 	= builder.deliveryAddress;
	}

	/**
	 * @return the trackingId
	 */
	public TrackingId getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(TrackingId trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the customerId
	 */
	public CustomerId getCustomerId() {
		return customerId;
	}

	/**
	 * @return the restaurantId
	 */
	public RestaurantId getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}
	

	/**
	 * @return the price
	 */
	public Money getPrice() {
		return price;
	}
	
	/**
	 * @return
	 */
	public OrderAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private OrderId 				orderId; 
		private CustomerId 				customerId;
		private RestaurantId 			restaurantId;
		private List<OrderItem> items = Collections.emptyList();
		private Money 					price;
		private TrackingId 				trackingId;
		private OrderStatus 			orderStatus;
		private OrderAddress 			deliveryAddress;
		

		private Builder() {
		}
		
		public Builder orderId(OrderId value) {
			orderId = value; 
			return this;
		}

		public Builder withCustomerId(CustomerId customerId) {
			this.customerId = customerId;
			return this;
		}

		public Builder withRestaurantId(RestaurantId restaurantId) {
			this.restaurantId = restaurantId;
			return this;
		}

		public Builder withItems(List<OrderItem> items) {
			this.items = items;
			return this;
		}

		public Builder withPrice(Money price) {
			this.price = price;
			return this;
		}

		public Builder withTrackingId(TrackingId trackingId) {
			this.trackingId = trackingId;
			return this;
		}

		public Builder withOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}
		
		public Builder withOrderAddress(OrderAddress value) {
			this.deliveryAddress = value;
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	} 
	
	
	public void approveOrder() {
		if(OrderStatus.PAID != orderStatus) {
			LOG.error("Order Status is not in the correct statue for approve order: ");
			throw new DomainException("Order Status is not in the correct statue for approve order: ");
		}
		
		orderStatus = OrderStatus.APPROVED;
	}
	
	
	public void cancelOrder() {
		if(!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
			LOG.error("Order Status is not in the correct statue for cancel order: ");
			throw new DomainException("Order Status is not in the correct statue for cancel order: ");
		}
		
		orderStatus = OrderStatus.CANCELLED;
	}
}

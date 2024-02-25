package com.itlogiclab.restaurant.order.domain.dto.query;

import java.util.UUID;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderStatus;

public class TrackOrderResponse {
	
	private UUID 		trackingId; 
	private OrderStatus orderStatus;
	private Order 		order;

	
	private TrackOrderResponse(Builder builder) {
		this.trackingId 	= builder.trackingId;
		this.orderStatus 	= builder.orderStatus;
		this.order 			= builder.order;
	}
	/**
	 * @return the trackingId
	 */
	public UUID getTrackingId() {
		return trackingId;
	}
	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private UUID trackingId;
		private OrderStatus orderStatus;
		private Order order;

		private Builder() {
		}

		public Builder withTrackingId(UUID trackingId) {
			this.trackingId = trackingId;
			return this;
		}

		public Builder withOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}

		public Builder withOrder(Order order) {
			this.order = order;
			return this;
		}

		public TrackOrderResponse build() {
			return new TrackOrderResponse(this);
		}
	}
}

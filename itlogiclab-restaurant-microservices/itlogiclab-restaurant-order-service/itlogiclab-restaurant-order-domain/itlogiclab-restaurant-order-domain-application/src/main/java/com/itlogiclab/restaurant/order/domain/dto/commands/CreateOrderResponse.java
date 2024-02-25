package com.itlogiclab.restaurant.order.domain.dto.commands;

import java.util.UUID;

import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderStatus;

public class CreateOrderResponse {
	
	private UUID trackingId; 
	
	private OrderStatus orderStatus;

	private CreateOrderResponse(Builder builder) {
		this.trackingId 	= builder.trackingId;
		this.orderStatus 	= builder.orderStatus;
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


	public static Builder builder() {
		return new Builder();
	}


	public static final class Builder {
		private UUID 		trackingId;
		private OrderStatus orderStatus;

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

		public CreateOrderResponse build() {
			return new CreateOrderResponse(this);
		}
	}

	
	

}

package com.itlogiclab.restaurant.order.domain.dto.query;

import java.util.UUID;

public class TrackOrderQuery {
	
	private final UUID orderTrackingId;

	private TrackOrderQuery(Builder builder) {
		this.orderTrackingId = builder.orderTrackingId;
	}

	/**
	 * @return the orderTrackingId
	 */
	public UUID getOrderTrackingId() {
		return orderTrackingId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private UUID orderTrackingId;

		private Builder() {
		}

		public Builder withOrderTrackingId(UUID orderTrackingId) {
			this.orderTrackingId = orderTrackingId;
			return this;
		}

		public TrackOrderQuery build() {
			return new TrackOrderQuery(this);
		}
	}
	
}

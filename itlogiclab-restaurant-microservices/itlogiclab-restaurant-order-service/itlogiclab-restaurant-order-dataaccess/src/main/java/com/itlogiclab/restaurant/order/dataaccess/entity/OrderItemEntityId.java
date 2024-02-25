package com.itlogiclab.restaurant.order.dataaccess.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemEntityId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id; 
	private OrderEntity order;
	
	public OrderItemEntityId() {
		// TODO Auto-generated constructor stub
	}
	
	private OrderItemEntityId(Builder builder) {
		this.id 		= builder.id;
		this.order 		= builder.order;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the order
	 */
	public OrderEntity getOrder() {
		return order;
	}
	public static Builder builder() {
		return new Builder();
	}

	
	public static final class Builder {
		private Long id;
		private OrderEntity order;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withOrder(OrderEntity order) {
			this.order = order;
			return this;
		}

		public OrderItemEntityId build() {
			return new OrderItemEntityId(this);
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemEntityId other = (OrderItemEntityId) obj;
		return Objects.equals(id, other.id) && Objects.equals(order, other.order);
	}
}

package com.itlogiclab.restaurant.order.domain.core.entity;

import com.itlogiclab.restaurant.order.domain.core.valueobject.Money;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId>{

	private OrderId 			orderId; 
	private OrderItemId 		orderItemId;
	
	private final Product 		product; 
	private final Money			itemPrice; 
	private final int 			quantity  ;

	private OrderItem(Builder builder) {
		setId(orderItemId);
		this.orderId 	= builder.orderId;
		this.product 	= builder.product;
		this.itemPrice 	= builder.itemPrice;
		this.quantity 	= builder.quantity;
	}

	/**
	 * @return the orderId
	 */
	public OrderId getOrderId() {
		return orderId;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the itemPrice
	 */
	public Money getItemPrice() {
		return itemPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private OrderId 		orderId;
		private OrderItemId 	orderItemId; 
		private Product 		product;
		private Money 			itemPrice;
		private int 			quantity;

		private Builder() {
		}

		public Builder withOrderId(OrderId orderId) {
			this.orderId = orderId;
			return this;
		}
		
		public Builder withOrderItemId(OrderItemId value) {
			this.orderItemId = value;
			return this;
		}

		public Builder withProduct(Product product) {
			this.product = product;
			return this;
		}

		public Builder withItemPrice(Money itemPrice) {
			this.itemPrice = itemPrice;
			return this;
		}

		public Builder withQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public OrderItem build() {
			return new OrderItem(this);
		}
	}
}

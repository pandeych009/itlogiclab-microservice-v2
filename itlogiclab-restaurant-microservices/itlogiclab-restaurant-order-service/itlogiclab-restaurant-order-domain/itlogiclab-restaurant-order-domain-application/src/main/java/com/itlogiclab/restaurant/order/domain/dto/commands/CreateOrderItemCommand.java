package com.itlogiclab.restaurant.order.domain.dto.commands;

import java.math.BigDecimal;

public class CreateOrderItemCommand {

	private final Long productId;

	private final Integer quantity; 

	private final BigDecimal price;

	private CreateOrderItemCommand(Builder builder) {
		
		this.productId 	= builder.productId;
		this.quantity 	= builder.quantity;
		this.price 		= builder.price;
	}
	
	public CreateOrderItemCommand() {
		this.productId = null;
		this.quantity = null;
		this.price = null;
	}
	
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderItem [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long 		productId;
		private Integer 	quantity;
		private BigDecimal 	price;

		private Builder() {
		}

		public Builder withProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		public Builder withQuantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public CreateOrderItemCommand build() {
			return new CreateOrderItemCommand(this);
		}
	}
}

package com.itlogiclab.restaurant.order.domain.dto.commands;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collections;

public class CreateOrderCommand {
	
	private Long 			customerId; 
	
	private Long 			restaurantId; 
	
	private BigDecimal 		price; 
	
	private List<CreateOrderItemCommand> items; 
	
	private CreateOrderAddressCommand 	address;
	
	public CreateOrderCommand() {
		// TODO Auto-generated constructor stub
	}

	private CreateOrderCommand(Builder builder) {
		this.customerId 	= builder.customerId;
		this.restaurantId 	= builder.restaurantId;
		this.price 			= builder.price;
		this.items 			= builder.items;
		this.address 		= builder.address;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @return the restaurantId
	 */
	public Long getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return the items
	 */
	public List<CreateOrderItemCommand> getItems() {
		return items;
	}

	/**
	 * @return the address
	 */
	public CreateOrderAddressCommand getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "CreateOrderCommand [customerId=" + customerId + ", restaurantId=" + restaurantId + ", price=" + price
				+ ", items=" + items + ", address=" + address + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long 						 customerId;
		private Long 						 restaurantId;
		private BigDecimal 					 price;
		private List<CreateOrderItemCommand> items = Collections.emptyList();
		private CreateOrderAddressCommand    address;

		private Builder() {
		}

		public Builder withCustomerId(Long customerId) {
			this.customerId = customerId;
			return this;
		}

		public Builder withRestaurantId(Long restaurantId) {
			this.restaurantId = restaurantId;
			return this;
		}

		public Builder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public Builder withItems(List<CreateOrderItemCommand> items) {
			this.items = items;
			return this;
		}

		public Builder withAddress(CreateOrderAddressCommand address) {
			this.address = address;
			return this;
		}

		public CreateOrderCommand build() {
			return new CreateOrderCommand(this);
		}
	} 
}

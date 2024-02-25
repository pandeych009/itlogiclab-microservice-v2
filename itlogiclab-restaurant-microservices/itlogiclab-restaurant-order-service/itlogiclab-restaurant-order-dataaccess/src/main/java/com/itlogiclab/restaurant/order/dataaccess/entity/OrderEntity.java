package com.itlogiclab.restaurant.order.dataaccess.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collections;

@Table(name =  "orders")
@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	private Long orderId; 

	@Column(name = "customer_id")
	private Long customerId; 

	@Column(name = "restaurant_id")
	private Long restaurantId; 

	@Column(name = "tracking_id")
	private UUID trackingId; 

	private BigDecimal price; 

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus status; 

	@Column(name = "failure_messages")
	private String failureMessage; 

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private OrderAddressEntity address; 

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItemEntity> items;
	

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the restaurantId
	 */
	public Long getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * @return the trackingId
	 */
	public UUID getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/**
	 * @return the failureMessage
	 */
	public String getFailureMessage() {
		return failureMessage;
	}

	/**
	 * @param failureMessage the failureMessage to set
	 */
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	/**
	 * @return the address
	 */
	public OrderAddressEntity getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(OrderAddressEntity address) {
		this.address = address;
	}

	/**
	 * @return the items
	 */
	public List<OrderItemEntity> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItemEntity> items) {
		this.items = items;
	}

	public OrderEntity(Builder builder) {
		this.orderId 		= builder.orderId;
		this.customerId 	= builder.customerId;
		this.restaurantId 	= builder.restaurantId;
		this.trackingId 	= builder.trackingId;
		this.price 			= builder.price;
		this.status 		= builder.status;
		this.failureMessage = builder.failureMessage;
		this.address 		= builder.address;
		this.items 			= builder.items;
	}
	
	public OrderEntity() {
		// TODO Auto-generated constructor stub
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long orderId;
		private Long customerId;
		private Long restaurantId;
		private UUID trackingId;
		private BigDecimal price;
		private OrderStatus status;
		private String failureMessage;
		private OrderAddressEntity address;
		private List<OrderItemEntity> items = Collections.emptyList();

		private Builder() {
		}

		public Builder withOrderId(Long orderId) {
			this.orderId = orderId;
			return this;
		}

		public Builder withCustomerId(Long customerId) {
			this.customerId = customerId;
			return this;
		}

		public Builder withRestaurantId(Long restaurantId) {
			this.restaurantId = restaurantId;
			return this;
		}

		public Builder withTrackingId(UUID trackingId) {
			this.trackingId = trackingId;
			return this;
		}

		public Builder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public Builder withStatus(OrderStatus status) {
			this.status = status;
			return this;
		}

		public Builder withFailureMessage(String failureMessage) {
			this.failureMessage = failureMessage;
			return this;
		}

		public Builder withAddress(OrderAddressEntity address) {
			this.address = address;
			return this;
		}

		public Builder withItems(List<OrderItemEntity> items) {
			this.items = items;
			return this;
		}

		public OrderEntity build() {
			return new OrderEntity(this);
		}
	} 
}

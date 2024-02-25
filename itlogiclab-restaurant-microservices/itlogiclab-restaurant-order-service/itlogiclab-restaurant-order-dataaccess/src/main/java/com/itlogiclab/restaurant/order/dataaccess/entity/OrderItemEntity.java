package com.itlogiclab.restaurant.order.dataaccess.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
@IdClass(OrderItemEntityId.class)
public class OrderItemEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private OrderEntity order; 
	
	@Column(name = "product_id")
	private Long 		productId; 
	private BigDecimal 	price;
	private Integer 	quantity;

	
	public OrderItemEntity() {
		// TODO Auto-generated constructor stub
	}
	
	private OrderItemEntity(Builder builder) {
		this.id 		= builder.id;
		this.order 		= builder.order;
		this.productId 	= builder.productId;
		this.price 		= builder.price;
		this.quantity 	= builder.quantity;
	}
	/**
	 * @return the order
	 */
	public OrderEntity getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long 			id;
		private OrderEntity 	order;
		private Long 			productId;
		private BigDecimal 		price;
		private Integer 		quantity;

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

		public Builder withProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		public Builder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public Builder withQuantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public OrderItemEntity build() {
			return new OrderItemEntity(this);
		}
	}
	
}

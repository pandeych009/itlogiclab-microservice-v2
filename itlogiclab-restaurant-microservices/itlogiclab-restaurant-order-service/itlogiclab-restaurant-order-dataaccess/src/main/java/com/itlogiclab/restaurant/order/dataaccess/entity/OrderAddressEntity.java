package com.itlogiclab.restaurant.order.dataaccess.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "order_address")
@Entity
public class OrderAddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private OrderEntity order;
	
	private String 		line1;
	private String 		line2;
	private String 		city;
	private String 		state;
	private String 		country;

	public OrderAddressEntity() {
		// TODO Auto-generated constructor stub
	}
	
	private OrderAddressEntity(Builder builder) {
		this.id 		= builder.id;
		this.order 		= builder.order;
		this.line1 		= builder.line1;
		this.line2 		= builder.line2;
		this.city 		= builder.city;
		this.state 		= builder.state;
		this.country 	= builder.country;
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
	
	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}
	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	public static Builder builder() {
		return new Builder();
	}

	
	public static final class Builder {
		private Long 		id;
		private OrderEntity order;
		private String 		line1;
		private String 		line2;
		private String 		city;
		private String 		state;
		private String 		country;

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

		public Builder withLine1(String line1) {
			this.line1 = line1;
			return this;
		}

		public Builder withLine2(String line2) {
			this.line2 = line2;
			return this;
		}

		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		public Builder withState(String state) {
			this.state = state;
			return this;
		}

		public Builder withCountry(String country) {
			this.country = country;
			return this;
		}

		public OrderAddressEntity build() {
			return new OrderAddressEntity(this);
		}
	}
}

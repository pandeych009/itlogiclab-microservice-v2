package com.itlogiclab.restaurant.order.domain.core.entity;

import java.util.Objects;

public class OrderAddress {
	
	private Long 		id; 
	private String 		line1;
	private String 		line2;
	private String 		city;
	private String 		state;
	private String 		country;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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

	private OrderAddress(Builder builder) {
		this.id = builder.id;
		this.line1 = builder.line1;
		this.line2 = builder.line2;
		this.city = builder.city;
		this.state = builder.state;
		this.country = builder.country;
	}

	public static Builder builder() {
		return new Builder();
	}

	
	public static final class Builder {
		private Long id;
		private String line1;
		private String line2;
		private String city;
		private String state;
		private String country;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
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

		public OrderAddress build() {
			return new OrderAddress(this);
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, country, id, line1, line2, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderAddress other = (OrderAddress) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(line1, other.line1)
				&& Objects.equals(line2, other.line2) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "OrderAddress [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
}

package com.itlogiclab.restaurant.order.domain.dto.commands;


public class CreateOrderAddressCommand {
	
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
	
	public CreateOrderAddressCommand() {
		// TODO Auto-generated constructor stub
	}
	
	private CreateOrderAddressCommand(Builder builder) {
		this.line1 		= builder.line1;
		this.line2 		= builder.line2;
		this.city 		= builder.city;
		this.state 		= builder.state;
		this.country 	= builder.country;
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
		private String line1;
		private String line2;
		private String city;
		private String state;
		private String country;

		private Builder() {
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

		public CreateOrderAddressCommand build() {
			return new CreateOrderAddressCommand(this);
		}
	}
}

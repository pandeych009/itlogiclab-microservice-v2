package com.itlogiclab.restaurant.order.domain.core.entity;

import com.itlogiclab.restaurant.order.domain.core.valueobject.Money;
import com.itlogiclab.restaurant.order.domain.core.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {

	private String productName;
	private Money price;
	
	public Product(ProductId productId) {
		super.setId(productId);
	}


	public Product(String productName, Money price) {
		super();
		this.productName = productName;
		this.price = price;
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @return the price
	 */
	public Money getPrice() {
		return price;
	}
	
}

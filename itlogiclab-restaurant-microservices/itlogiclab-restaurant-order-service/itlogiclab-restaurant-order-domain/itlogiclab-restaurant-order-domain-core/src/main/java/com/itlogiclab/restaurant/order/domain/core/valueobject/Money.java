package com.itlogiclab.restaurant.order.domain.core.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


public class Money {

	public static final Money ZERO = new Money(BigDecimal.ZERO); 

	private final BigDecimal amount; 


	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}


	public boolean isGreaterThanZero() {
		return Objects.nonNull(amount) && this.amount.compareTo(BigDecimal.ZERO) > 0 ; 
	}


	public boolean isGreaterThan(Money money) {
		return Objects.nonNull(amount) && this.amount.compareTo(money.getAmount()) > 0; 
	}

	public Money add(Money money) {
		return new Money(setScale(this.amount.add(money.getAmount())));
	}

	public Money subtract(Money money) {
		return new Money(setScale(this.amount.subtract(money.getAmount())));
	}

	public Money multiply(int multiplier) {
		return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
	}

	private BigDecimal setScale(BigDecimal amount) {
		return amount.setScale(2, RoundingMode.HALF_EVEN);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}

}

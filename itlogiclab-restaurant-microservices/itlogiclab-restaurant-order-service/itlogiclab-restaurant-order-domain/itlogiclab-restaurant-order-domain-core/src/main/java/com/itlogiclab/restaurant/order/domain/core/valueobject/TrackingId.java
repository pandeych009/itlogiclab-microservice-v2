package com.itlogiclab.restaurant.order.domain.core.valueobject;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
	
	public TrackingId(UUID value) {
		super(value);
	}

}

package com.itlogiclab.restaurant.order.domain.core.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DomainApplicationUtils {
	
	private DomainApplicationUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static final String 	UTC_TZ 			= "UTC";
	public static ZonedDateTime CURRENT_DATE 	= ZonedDateTime.now(ZoneId.of(UTC_TZ));

}

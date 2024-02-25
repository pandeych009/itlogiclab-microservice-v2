package com.itlogiclab.restaurant.order.domain.output.reopsitory;

import com.itlogiclab.restaurant.order.domain.core.entity.Order;
import com.itlogiclab.restaurant.order.domain.core.valueobject.OrderId;
import com.itlogiclab.restaurant.order.domain.core.valueobject.TrackingId;

public interface OrderRepository {

	Order save(Order order);

	Order findByTrackingId(TrackingId trackingId); 

	Order findById(OrderId orderId); 

}

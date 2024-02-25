package com.itlogiclab.restaurant.order.dataaccess.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlogiclab.restaurant.order.dataaccess.entity.OrderEntity;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderEntity, Long>{
	Optional<OrderEntity> findByTrackingId(UUID trackingId);
}

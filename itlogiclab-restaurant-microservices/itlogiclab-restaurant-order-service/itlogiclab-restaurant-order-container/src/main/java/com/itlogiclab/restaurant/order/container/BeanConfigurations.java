package com.itlogiclab.restaurant.order.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itlogiclab.restaurant.order.domain.core.OrderDomainService;
import com.itlogiclab.restaurant.order.domain.core.OrderDomainServiceImpl;

@Configuration
public class BeanConfigurations{
	private static final Logger LOG = LoggerFactory.getLogger(BeanConfigurations.class);
	
	@Bean
	public OrderDomainService orderDomainService() {
		return new OrderDomainServiceImpl();
	}

}

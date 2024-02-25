package com.itlogiclab.restaurant.order.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.itlogiclab.restaurant.common.dataaccess.config.DataSourceConfigParant;

@SpringBootApplication(scanBasePackages = "com.itlogiclab.restaurant.order")
@EnableJpaRepositories(basePackages = "com.itlogiclab.restaurant.order")
@EntityScan(basePackages = "com.itlogiclab.restaurant.order")
public class ItlogiclabRestaurantApplication implements CommandLineRunner{
	
private static Logger LOG = LoggerFactory.getLogger(ItlogiclabRestaurantApplication.class); 
	
//	private final DataSourceConfigParant dataSourceConfig; 
//	
//	
//	public ItlogiclabRestaurantApplication(DataSourceConfigParant dataSourceConfig) {
//		super();
//		this.dataSourceConfig = dataSourceConfig;
//	}



	public static void main(String[] args) {
		LOG.info("OrderServiceApplication is about to start");
		SpringApplication.run(ItlogiclabRestaurantApplication.class, args);
	}

	
	@Override
		public void run(String... args) throws Exception {
			LOG.info("ItlogiclabRestaurantApplication: DatasourceConfig: ");
			
		}
}

package com.itlogiclab.restaurant.order.dataaccess.config;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.itlogiclab.restaurant.common.dataaccess.config.DataSourceConfig;
import com.itlogiclab.restaurant.common.dataaccess.config.DataSourceConfigParant;
import com.itlogiclab.restaurant.common.dataaccess.utils.DataAccessConstants;

import jakarta.persistence.EntityManagerFactory;


//@Configuration
//@EnableTransactionManagement
public class TomcatFactoryConfig {
	
	private static Logger LOG = LoggerFactory.getLogger(TomcatFactoryConfig.class); 
	
	@Bean
	public DataSourceConfigParant getDataSourceConfig() {
		DataSourceConfigParant datasourceConfig = new DataSourceConfig();
		return datasourceConfig;
	}
	
	@Bean
	public TomcatServletWebServerFactory getTomcatFactory() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			
			@Override
			public TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
	        protected void postProcessContext(Context context) {
				
				DataSourceConfigParant tomcatJNDIProps = getDataSourceConfig();
				LOG.info("DataSourceConfig: "+tomcatJNDIProps);
				ContextResource resource = new ContextResource();
	            resource.setName(getDataSourceConfig().getJndiName());
	            resource.setType(DataSource.class.getName());
	            
	            resource.setProperty(DataAccessConstants.FACTORY, "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	            
	            resource.setProperty(DataAccessConstants.DRIVER_CLASS_NAME, 				tomcatJNDIProps.getDriverClassName());

	            resource.setProperty(DataAccessConstants.URL, 								tomcatJNDIProps.getUrl());
	            resource.setProperty(DataAccessConstants.USERNAME, 							tomcatJNDIProps.getUsername());
	            resource.setProperty(DataAccessConstants.PASSWORD, 							tomcatJNDIProps.getPassword());
	            
	            resource.setProperty(DataAccessConstants.INITIAL_SIZE, 						tomcatJNDIProps.getInitialSize());
	            resource.setProperty(DataAccessConstants.MAX_ACTIVE, 						tomcatJNDIProps.getMaxActive());
	            resource.setProperty(DataAccessConstants.MAX_IDLE, 							tomcatJNDIProps.getMaxIdle());
	            resource.setProperty(DataAccessConstants.MAX_WAIT, 							tomcatJNDIProps.getMaxWait());
	            resource.setProperty(DataAccessConstants.MIN_EVICTABLE_IDLE_TIME_MILLIS, 	tomcatJNDIProps.getMinEvictableIdleTimeMillis());
	            resource.setProperty(DataAccessConstants.MIN_IDLE, 							tomcatJNDIProps.getMinIdle());
	            
	            resource.setProperty(DataAccessConstants.REMOVE_ABANDONED_TIME_OUT, 		tomcatJNDIProps.getRemoveAbandonedTimeout());
	            resource.setProperty(DataAccessConstants.TIME_BETWEEN_EVICTION_RUNS_MILLIS, tomcatJNDIProps.getTimeBetweenEvictionRunsMillis());
	            resource.setProperty(DataAccessConstants.VALIDATION_QUERY, 					tomcatJNDIProps.getValidationQuery());
	            resource.setProperty(DataAccessConstants.VALIDATION_QUERY_TIMEOUT, 			tomcatJNDIProps.getValidationQueryTimeout());
	            
	            resource.setProperty(DataAccessConstants.DEFAULT_AUTO_COMMIT, 				String.valueOf(tomcatJNDIProps.getDefaultAutoCommit()));
	            resource.setProperty(DataAccessConstants.DEFAULT_READ_ONLY, 				String.valueOf(tomcatJNDIProps.getDefaultReadOnly()));
	            resource.setProperty(DataAccessConstants.LOG_ABANDONED, 					String.valueOf(tomcatJNDIProps.getLogAbandoned()));
	            resource.setProperty(DataAccessConstants.TEST_ON_BORROW, 					String.valueOf(tomcatJNDIProps.getTestOnBorrow()));
	            resource.setProperty(DataAccessConstants.TEST_ON_CONNECT, 					String.valueOf(tomcatJNDIProps.getTestOnConnect()));
	            resource.setProperty(DataAccessConstants.TEST_ON_RETURN, 					String.valueOf(tomcatJNDIProps.getTestOnReturn()));
	            resource.setProperty(DataAccessConstants.REMOVE_ABANDONED, 					String.valueOf(tomcatJNDIProps.getRemoveAbandoned()));
	            
	            
	            
	            //context.getNamingResources().addResource(resource);  
	        }
	    };
	    return tomcat;
	}
	
	//@Bean(destroyMethod = "")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName(DataAccessConstants.JAVA_COMP_ENV + getDataSourceConfig().getJndiName());
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}
	
	//@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException, IllegalArgumentException, NamingException {
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getDataSourceConfig().getEntityPackageToScan().split(","));

		factory.setDataSource(jndiDataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	//@Bean
	public PlatformTransactionManager transactionManager()throws SQLException, IllegalArgumentException, NamingException {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

}

package com.itlogiclab.restaurant.common.dataaccess.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import com.itlogiclab.restaurant.common.dataaccess.utils.DataAccessConstants;

public class DataSourceConfig extends DataSourceConfigParant implements EnvironmentAware{
	
	private static Environment environment;

	public DataSourceConfig() {
		super();
	}
	
	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		DataSourceConfig.environment = environment;
	}
	
	@Override
	public String getJndiName() {
		return environment.getProperty(DataAccessConstants.ENV_JNDI_NAME, super.getJndiName());
	}

	@Override
	public String getAuth() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_AUTH, super.getAuth());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_TYPE,  super.getType());
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_URL,  super.getUrl());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_USERNAME,  super.getUsername());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_PASSWORD,  super.getPassword());
	}

	@Override
	public String getDefaultAutoCommit() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_AUTOCOMMIT,  super.getDefaultAutoCommit());
	}

	@Override
	public String getDefaultReadOnly() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_READONLY,  super.getDefaultReadOnly());
	}

	@Override
	public String getDriverClassName() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_DRIVER_CLASSNAME,  super.getDriverClassName());
	}

	@Override
	public String getMaxActive() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_MAX_ACTIVE,  super.getMaxActive());
	}

	@Override
	public String getMaxIdle() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_MAX_IDLE,  super.getMaxIdle());
	}

	@Override
	public String getMinIdle() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_MIN_IDLE,  super.getMinIdle());
	}

	@Override
	public String getInitialSize() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_INITIAL_SIZE,  super.getInitialSize());
	}

	@Override
	public String getMaxWait() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_MAX_WAIT,  super.getMaxWait());
	}

	@Override
	public String getTestOnBorrow() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_TEST_ON_BORROW,  super.getTestOnBorrow());
	}

	@Override
	public String getTestOnConnect() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_TEST_ON_CONNECT,  super.getTestOnConnect());
	}
	
	
	@Override
	public String getTestWhileIdle() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_WHILE_IDLE,  super.getTestWhileIdle());
	}

	@Override
	public String getValidationQuery() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_VALIDATION_QUERY,  super.getValidationQuery());
	}

	@Override
	public String getValidationQueryTimeout() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_VALIDATION_QUERY_TIMEOUT,  super.getValidationQueryTimeout());
	}

	@Override
	public String getValidatorClassName() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_VALIDATIOR_CLASS_NAME,  super.getValidatorClassName());
	}

	@Override
	public String getTimeBetweenEvictionRunsMillis() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_TIME_BETWEEN_EVICTION_RUNS_MILLIS,  super.getTimeBetweenEvictionRunsMillis());
	}

	@Override
	public String getMinEvictableIdleTimeMillis() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_MIN_EVICTABLE_IDLE_TIME_MILLIS,  super.getMinEvictableIdleTimeMillis());
	}

	@Override
	public String getRemoveAbandoned() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_REMOVE_ABANDON,  super.getRemoveAbandoned());
	}

	@Override
	public String getRemoveAbandonedTimeout() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_REMOVE_ABANDON_TIMEOUT,  super.getRemoveAbandonedTimeout());
	}

	@Override
	public String getLogAbandoned() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_LOG_ABANDON,  super.getLogAbandoned());
	}

	@Override
	public String getTestOnReturn() {
		// TODO Auto-generated method stub
		return environment.getProperty(DataAccessConstants.ENV_TEST_ON_RETURN,  super.getTestOnReturn());
	}

	@Override
	public String toString() {
		return "DataSourceConfig [env=" + environment + ", getJndiName()=" + getJndiName() + ", getAuth()=" + getAuth()
				+ ", getType()=" + getType() + ", getUrl()=" + getUrl() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getDefaultAutoCommit()=" + getDefaultAutoCommit()
				+ ", getDefaultReadOnly()=" + getDefaultReadOnly() + ", getDriverClassName()=" + getDriverClassName()
				+ ", getMaxActive()=" + getMaxActive() + ", getMaxIdle()=" + getMaxIdle() + ", getMinIdle()="
				+ getMinIdle() + ", getInitialSize()=" + getInitialSize() + ", getMaxWait()=" + getMaxWait()
				+ ", getTestOnBorrow()=" + getTestOnBorrow() + ", getTestOnConnect()=" + getTestOnConnect()
				+ ", getTestWhileIdle()=" + getTestWhileIdle() + ", getValidationQuery()=" + getValidationQuery()
				+ ", getValidationQueryTimeout()=" + getValidationQueryTimeout() + ", getValidatorClassName()="
				+ getValidatorClassName() + ", getTimeBetweenEvictionRunsMillis()=" + getTimeBetweenEvictionRunsMillis()
				+ ", getMinEvictableIdleTimeMillis()=" + getMinEvictableIdleTimeMillis() + ", getRemoveAbandoned()="
				+ getRemoveAbandoned() + ", getRemoveAbandonedTimeout()=" + getRemoveAbandonedTimeout()
				+ ", getLogAbandoned()=" + getLogAbandoned() + ", getTestOnReturn()=" + getTestOnReturn() + "]";
	}
}

package com.itlogiclab.restaurant.common.dataaccess.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:datasource.properties"})
@ConfigurationProperties(prefix = "database")
public class DataSourceConfigParant {
	
	private String jndiName;
	private String auth;
	private String type; 
	private String url;
	private String username;
	private String password;
	private String defaultAutoCommit;	
	private String defaultReadOnly;	
	private String driverClassName;	
	private String maxActive;	
	private String maxIdle;	
	private String minIdle;
	private String initialSize;
	private String maxWait;	
	private String testOnBorrow;
	private String testOnConnect;
	private String testOnReturn;
	private String testWhileIdle;
	private String validationQuery;
	private String validationQueryTimeout;
	private String validatorClassName;
	private String timeBetweenEvictionRunsMillis;	
	private String minEvictableIdleTimeMillis	;
	private String removeAbandoned;	
	private String removeAbandonedTimeout;
	private String logAbandoned;
	private String entityPackageToScan;
	
	
	/**
	 * @return the jndiName
	 */
	public String getJndiName() {
		return jndiName;
	}
	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the defaultAutoCommit
	 */
	public String getDefaultAutoCommit() {
		return defaultAutoCommit;
	}
	/**
	 * @return the defaultReadOnly
	 */
	public String getDefaultReadOnly() {
		return defaultReadOnly;
	}
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}
	/**
	 * @return the maxActive
	 */
	public String getMaxActive() {
		return maxActive;
	}
	/**
	 * @return the maxIdle
	 */
	public String getMaxIdle() {
		return maxIdle;
	}
	/**
	 * @return the minIdle
	 */
	public String getMinIdle() {
		return minIdle;
	}
	/**
	 * @return the initialSize
	 */
	public String getInitialSize() {
		return initialSize;
	}
	/**
	 * @return the maxWait
	 */
	public String getMaxWait() {
		return maxWait;
	}
	/**
	 * @return the testOnBorrow
	 */
	public String getTestOnBorrow() {
		return testOnBorrow;
	}
	/**
	 * @return the testOnConnect
	 */
	public String getTestOnConnect() {
		return testOnConnect;
	}
	/**
	 * @return the testOnReturn
	 */
	public String getTestOnReturn() {
		return testOnReturn;
	}
	/**
	 * @return the testWhileIdle
	 */
	public String getTestWhileIdle() {
		return testWhileIdle;
	}
	/**
	 * @return the validationQuery
	 */
	public String getValidationQuery() {
		return validationQuery;
	}
	/**
	 * @return the validationQueryTimeout
	 */
	public String getValidationQueryTimeout() {
		return validationQueryTimeout;
	}
	/**
	 * @return the validatorClassName
	 */
	public String getValidatorClassName() {
		return validatorClassName;
	}
	/**
	 * @return the timeBetweenEvictionRunsMillis
	 */
	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	/**
	 * @return the minEvictableIdleTimeMillis
	 */
	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	/**
	 * @return the removeAbandoned
	 */
	public String getRemoveAbandoned() {
		return removeAbandoned;
	}
	/**
	 * @return the removeAbandonedTimeout
	 */
	public String getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}
	/**
	 * @return the logAbandoned
	 */
	public String getLogAbandoned() {
		return logAbandoned;
	}
	
	
	@Override
	public String toString() {
		return "DataSourceConfig [jndiName=" + jndiName + ", auth=" + auth + ", type=" + type + ", url=" + url
				+ ", username=" + username + ", password=*****" + password + ", defaultAutoCommit=" + defaultAutoCommit
				+ ", defaultReadOnly=" + defaultReadOnly + ", driverClassName=" + driverClassName + ", maxActive="
				+ maxActive + ", maxIdle=" + maxIdle + ", minIdle=" + minIdle + ", initialSize=" + initialSize
				+ ", maxWait=" + maxWait + ", testOnBorrow=" + testOnBorrow + ", testOnConnect=" + testOnConnect
				+ ", testOnReturn=" + testOnReturn + ", testWhileIdle=" + testWhileIdle + ", validationQuery="
				+ validationQuery + ", validationQueryTimeout=" + validationQueryTimeout + ", validatorClassName="
				+ validatorClassName + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis
				+ ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis + ", removeAbandoned=" + removeAbandoned
				+ ", removeAbandonedTimeout=" + removeAbandonedTimeout + ", logAbandoned=" + logAbandoned + "]";
	}
	/**
	 * @param jndiName the jndiName to set
	 */
	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param defaultAutoCommit the defaultAutoCommit to set
	 */
	public void setDefaultAutoCommit(String defaultAutoCommit) {
		this.defaultAutoCommit = defaultAutoCommit;
	}
	/**
	 * @param defaultReadOnly the defaultReadOnly to set
	 */
	public void setDefaultReadOnly(String defaultReadOnly) {
		this.defaultReadOnly = defaultReadOnly;
	}
	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	/**
	 * @param maxActive the maxActive to set
	 */
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	/**
	 * @param maxIdle the maxIdle to set
	 */
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}
	/**
	 * @param minIdle the minIdle to set
	 */
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
	/**
	 * @param initialSize the initialSize to set
	 */
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	/**
	 * @param maxWait the maxWait to set
	 */
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}
	/**
	 * @param testOnBorrow the testOnBorrow to set
	 */
	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	/**
	 * @param testOnConnect the testOnConnect to set
	 */
	public void setTestOnConnect(String testOnConnect) {
		this.testOnConnect = testOnConnect;
	}
	/**
	 * @param testOnReturn the testOnReturn to set
	 */
	public void setTestOnReturn(String testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	/**
	 * @param testWhileIdle the testWhileIdle to set
	 */
	public void setTestWhileIdle(String testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	/**
	 * @param validationQuery the validationQuery to set
	 */
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	/**
	 * @param validationQueryTimeout the validationQueryTimeout to set
	 */
	public void setValidationQueryTimeout(String validationQueryTimeout) {
		this.validationQueryTimeout = validationQueryTimeout;
	}
	/**
	 * @param validatorClassName the validatorClassName to set
	 */
	public void setValidatorClassName(String validatorClassName) {
		this.validatorClassName = validatorClassName;
	}
	/**
	 * @param timeBetweenEvictionRunsMillis the timeBetweenEvictionRunsMillis to set
	 */
	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	/**
	 * @param minEvictableIdleTimeMillis the minEvictableIdleTimeMillis to set
	 */
	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	/**
	 * @param removeAbandoned the removeAbandoned to set
	 */
	public void setRemoveAbandoned(String removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}
	/**
	 * @param removeAbandonedTimeout the removeAbandonedTimeout to set
	 */
	public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}
	/**
	 * @param logAbandoned the logAbandoned to set
	 */
	public void setLogAbandoned(String logAbandoned) {
		this.logAbandoned = logAbandoned;
	}
	/**
	 * @return the entityPackageToScan
	 */
	public String getEntityPackageToScan() {
		return entityPackageToScan;
	}
	/**
	 * @param entityPackageToScan the entityPackageToScan to set
	 */
	public void setEntityPackageToScan(String entityPackageToScan) {
		this.entityPackageToScan = entityPackageToScan;
	}
	
	
}

package com.organization.provider;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Learn the basics of Spring Transaction Management and the @Transactional annocation context. 
 * https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
 *
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.organization.provider.model.persistent")
@EnableJpaRepositories(basePackages = "com.organization.provider.repository") 
public class SpringPersistenceConfig {
	
	//Spring Boot creates a TransactionPlatformManager
}

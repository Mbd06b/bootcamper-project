package com.organization.mvcproject.app.config;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

//@SpringJUnitConfig(classes = MGLWebApplicationInitializer.class )
@CucumberContextConfiguration
@SpringBootTest
@ContextConfiguration(classes = MvcConfiguration.class)
public class SpringContextConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Before
	void contextLoads() {
		logger.debug("Context Loads");
		logger.info("----------------- Spring Context Initialized for Executing Cucumber Tests ------------------");	}
}

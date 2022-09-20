package com.organization.mvcproject.test;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.Before;

@SpringBootTest
class MglAutomationTestingApplicationTests {
	
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Before
	void contextLoads() {
		logger.debug("Context Loads");
		logger.info("----------------- Spring Context Initialized for Executing Cucumber Tests ------------------");	}

}

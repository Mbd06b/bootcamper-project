package com.organization.mvcproject.test;

import java.lang.invoke.MethodHandles;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MglAutomationTestingApplicationTests {
	
    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	void contextLoads() {
		logger.debug("Context Loads");
	}

}

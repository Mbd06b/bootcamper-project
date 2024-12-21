package com.organization.mvcproject.test.bdd;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import com.organization.mvcproject.app.config.MGLWebApplicationInitializer;
import com.organization.mvcproject.app.config.MvcConfiguration;
import com.organization.mvcproject.test.E2ETestContext;
import com.organization.mvcproject.test.WebDriverConfig;

import io.cucumber.spring.CucumberContextConfiguration;

 
@CucumberContextConfiguration
@WebAppConfiguration
@SpringJUnitConfig(classes = {
		MGLWebApplicationInitializer.class, 
		MvcConfiguration.class,
		WebDriverConfig.class,
		E2ETestContext.class
})
public class CucumberSpringConfig {
	

}
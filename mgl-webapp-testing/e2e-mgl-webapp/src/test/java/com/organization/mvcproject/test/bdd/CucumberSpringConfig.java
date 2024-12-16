package com.organization.mvcproject.test.bdd;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.organization.mvcproject.test.E2ETestContext;
import com.organization.mvcproject.test.WebDriverConfig;

import io.cucumber.spring.CucumberContextConfiguration;

 
@CucumberContextConfiguration
@SpringJUnitConfig(classes = {E2ETestContext.class, WebDriverConfig.class})
public class CucumberSpringConfig {
	

}
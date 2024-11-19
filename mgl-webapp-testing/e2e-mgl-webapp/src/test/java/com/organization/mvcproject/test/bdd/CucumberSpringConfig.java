package com.organization.mvcproject.test.bdd;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.organization.mvcproject.test.MGLSpringTestContext;
import com.organization.mvcproject.test.WebDriverConfig;

import io.cucumber.spring.CucumberContextConfiguration;

 
@CucumberContextConfiguration
@SpringJUnitConfig(classes = {WebDriverConfig.class, MGLSpringTestContext.class})
public class CucumberSpringConfig {
	

}
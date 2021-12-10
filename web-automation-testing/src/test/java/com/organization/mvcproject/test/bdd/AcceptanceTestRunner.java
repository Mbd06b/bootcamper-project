package com.organization.mvcproject.test.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html/target/cucumber",
features = "classpath:features")
public class AcceptanceTestRunner {
	

}

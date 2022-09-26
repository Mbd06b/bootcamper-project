package com.organization.mvcproject.bdd.test.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.organization.mvcproject.test.calculator.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefinitions {
	
	Calculator calculator; 
	Integer result; 
	
	@Given("I have a calculator")
	public void i_have_a_calculator() {
		
		calculator = new Calculator(); 
	    // Write code here that turns the phrase above into concrete actions
	}
	@When("I add {int} and {int}")
	public void i_add_and(Integer int1, Integer int2) {
		result = calculator.add(int1 ,int2);
}
	@Then("I should get {int}")
	public void i_should_get(Integer expectedResult) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		assertThat(result).isEqualTo(expectedResult);
	}

}

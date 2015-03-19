package jp.co.ycode.webapp.dictionary;

import java.util.logging.Logger;

import jp.co.ycode.webapp.TestSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Dictionary {
	private static final Logger LOGGER = Logger.getLogger(Dictionary.class.getName());
	
	@Given("^I navigate to the mock application$")
	public void given_I_navigate_to_the_mock_application(){
		LOGGER.info("Entering: I navigate to the mock application");
		TestSteps.given_I_navigate_to_the_mock_application();
	}
	
	@When("^I try to login with '(.+)' credentials$")
	public void when_I_try_to_login(String credentialsType){
		LOGGER.info("Entering: I try to login with " + credentialsType + " credentials");
		TestSteps.when_I_try_to_login(credentialsType);
	}
	
	@Then("^I should see that I logged in '(.+)'$")
	public void then_I_login(String outcome){
		LOGGER.info("Entering: I should see that I logged in " + outcome);
		TestSteps.then_I_login(outcome);
	}
}

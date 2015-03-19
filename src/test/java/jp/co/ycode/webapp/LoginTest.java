package jp.co.ycode.webapp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		tags = {"@login"})
public class LoginTest 
{
}

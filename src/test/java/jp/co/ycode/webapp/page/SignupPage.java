package jp.co.ycode.webapp.page;

import jp.co.ycode.webapp.browser.BrowserDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignupPage extends Page {
	
	@FindBy(how = How.CSS, using = "input[name=name]")
	public WebElement usernameInput;
	
	@FindBy(how = How.CSS, using = "input[name=password")
	public WebElement passwordInput;
	
	@FindBy(how = How.CSS, using = "input[name=email]")
	public WebElement emailInput;
	
	@FindBy(how = How.CSS, using = "input[name=firstName]")
	public WebElement firstNameInput;
	
	@FindBy(how = How.CSS, using = "input[name=lastName]")
	public WebElement lastNameInput;
	
	@FindBy(how = How.CSS, using = "input[name=submit]")
	public WebElement submitButton;

	@Override
	public void waitPageReady() {
		this.logger.info("Checking login page is displayed");
		BrowserDriver.waitForElement(this.usernameInput);
		this.usernameInput.isDisplayed();
	}
}

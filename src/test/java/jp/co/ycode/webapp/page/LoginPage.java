package jp.co.ycode.webapp.page;

import jp.co.ycode.webapp.browser.BrowserDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {
	private String validationContainerCSS = "div.dijitValidationContainer";

	@FindBy(how = How.ID, using = "login-box")
    public WebElement loginBoxDiv;
	
	@FindBy(how = How.CSS, using = "#login-box input[name=username]")
    public WebElement usernameInput;
	
	public WebElement getUsernameValidationDiv(){
		WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(usernameInput));
		return parent.findElement(By.cssSelector(validationContainerCSS));
	}
	
	@FindBy(how = How.CSS, using = "#login-box input[name=password]")
    public WebElement passwordInput;
	
	public WebElement getPasswordValidationDiv(){
		WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(passwordInput));
		return parent.findElement(By.cssSelector(validationContainerCSS));
	}
	
	@FindBy(how = How.CSS, using = "#login-box input[name=submit]")
    public WebElement submitButton;

	public void waitPageReady(){
		this.logger.info("Checking login page is displayed");
		BrowserDriver.waitForElement(this.loginBoxDiv);
		this.loginBoxDiv.isDisplayed();
	}
	
	public void login(String username, String password){
		this.logger.info("Logging in with username:" + username + " password:" + password);
		this.usernameInput.sendKeys(username);
		this.passwordInput.sendKeys(password);
		this.submitButton.click();
		this.logger.info("Login submitted");
	}
	
	public void checkLoginSuccess(){
		this.logger.info("Check login was successful");
		this.waitPageReady();	
	}
	
	public void checkLoginErrors(){
		this.logger.info("Check login errors displayed");
//		BrowserDriver.waitForElement(this.getUsernameValidationDiv());
//		BrowserDriver.waitForElement(this.getPasswordValidationDiv());
		BrowserDriver.waitForElement(this.loginBoxDiv);
		this.loginBoxDiv.isDisplayed();
	}
}

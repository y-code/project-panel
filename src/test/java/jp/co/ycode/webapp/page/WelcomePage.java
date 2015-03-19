package jp.co.ycode.webapp.page;

import jp.co.ycode.webapp.browser.BrowserDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage extends Page {

	@FindBy(how = How.CSS, using = "#HomePage h1")
    public WebElement homePageTitle;
	
	public void isDisplayedCheck(){
		this.logger.info("Checking login page is displayed");
		BrowserDriver.waitForElement(this.homePageTitle);
		this.homePageTitle.isDisplayed();
	}
}

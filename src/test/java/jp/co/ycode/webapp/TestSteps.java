package jp.co.ycode.webapp;

import jp.co.ycode.webapp.browser.BrowserDriver;
import jp.co.ycode.webapp.context.TestContext;
import jp.co.ycode.webapp.context.Users;
import jp.co.ycode.webapp.dictionary.CredentialsType;
import jp.co.ycode.webapp.dictionary.Outcome;
import jp.co.ycode.webapp.page.LoginPage;
import jp.co.ycode.webapp.page.PageFactory;

public class TestSteps {

	private static final TestContext CTX = TestContext.getInstance();
	
	public static void given_I_navigate_to_the_mock_application(){
		LoginPage page = PageFactory.get(LoginPage.class);
		BrowserDriver.loadPage(page.getUrl());
		page.isDisplayedCheck();
	}

	public static void when_I_try_to_login(String credentialsType) {
		CredentialsType ct = CredentialsType.credentialsTypeForName(credentialsType);
		switch(ct){
			case VALID:
				CTX.setUser(Users.createValidUser());
			break;
			case INVALID:
				CTX.setUser(Users.createInvalidUser());
			break;
		}
		PageFactory.get(LoginPage.class).login(CTX.getUser().getUsername(), CTX.getUser().getPassword());
	}
	
	public static void then_I_login(String outcomeString){
		Outcome outcome = Outcome.outcomeForName(outcomeString);
		switch(outcome){
			case SUCCESS:
				PageFactory.get(LoginPage.class).checkLoginSuccess();
			break;
			case FAILURE:
				PageFactory.get(LoginPage.class).checkLoginErrors();
			break;
		}
	}
}

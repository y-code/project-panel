package jp.co.ycode.webapp.page;

import java.util.HashMap;

import jp.co.ycode.webapp.browser.BrowserDriver;

public class PageFactory {
	
	private static HashMap<Class<? extends Page>, Page> PAGE_MAP = new HashMap<Class<? extends Page>, Page>();
	private static HashMap<Class<? extends Page>, String> URL_MAP = new HashMap<Class<? extends Page>, String>();
	
	static
	{
		URL_MAP.put(WelcomePage.class, "http://localhost:8080/welcome");
		URL_MAP.put(LoginPage.class, "http://localhost:8080/login");
		URL_MAP.put(SignupPage.class, "http://localhost:8080/signup");
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Page> T get(Class<T> pageClass)
	{
		T page;
		if (PAGE_MAP.containsKey(pageClass))
			page = (T) PAGE_MAP.get(pageClass);
		else
		{
			page = org.openqa.selenium.support.PageFactory.initElements(BrowserDriver.getCurrentDriver(), pageClass);
			page.setUrl(URL_MAP.get(pageClass));
			PAGE_MAP.put(pageClass, page);
		}
		return page;
	}
}

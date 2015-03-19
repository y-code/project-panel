package jp.co.ycode.webapp.context;

public class TestContext {
	
	private static final TestContext instance;
	
	static
	{
		instance = new TestContext();
	}
	
	public static TestContext getInstance()
	{
		return instance;
	}
	
	private TestContext()
	{
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

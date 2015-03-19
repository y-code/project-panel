package jp.co.ycode.webapp.page;

import java.util.logging.Logger;

public abstract class Page {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private String url = null;
	
	public String getUrl()
	{
		return this.url;
	}
	
	protected void setUrl(String url)
	{
		this.url = url;
	}
	
	public abstract void waitPageReady();
}

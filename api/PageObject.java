package qa.api;

import org.openqa.selenium.WebDriver;

import qa.po.benaughty.POBenaughty;

public class PageObject
{
	public WebDriver driver;
	
	/* Page objects */
	public POBenaughty benaughty;
	
	/**
	 * Constructor
	 * @param driver
	 */
	public PageObject (WebDriver driver)
	{
		this.initPO(driver);
	}
	
	/*
	 * Page Objects initialization
	 */
	public void initPO(WebDriver driver)
	{
		this.benaughty = new POBenaughty(driver);
	}
	
}

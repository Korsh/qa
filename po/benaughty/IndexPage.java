package qa.po.benaughty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.api.Locator;
import qa.api.Page;

public class IndexPage extends Page
{
	/** Page file **/
	public String PAGE_url = "/";
	
	public IndexPage(WebDriver driver, String siteName) 
	{
		super ();
		super.driver = driver;
		super.locator = new Locator(siteName, this.getClass().getSimpleName());
	}

	/**
	 * 
	 * @param login User's screenname or e-mail
	 * @param password User's password
	 */
	public void login(String login, String password)
	{	
		super.driver.switchTo().frame(super.locator.getLocator("frm_iframe", "id"));
		super.driver.findElement(By.id(super.locator.getLocator("txt_login", "id"))).sendKeys(login);
		super.driver.findElement(By.className(super.locator.getLocator("txt_password_login", "class"))).sendKeys(password);
		super.driver.findElement(By.className(super.locator.getLocator("btn_login", "class"))).click();
	}
}

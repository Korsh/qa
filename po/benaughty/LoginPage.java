package qa.po.benaughty;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.api.Locator;
import qa.api.Page;

public class LoginPage extends Page
{	
	/** Page file **/
	public String PAGE_url = "/login.html";
	
	public static final Logger LOG=Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver, String siteName) 
	{
		super ();
		super.driver = driver;
		super.locator = new Locator(siteName, this.getClass().getSimpleName());
	}

	/**
	 * Login to site
	 * @param login User's screenname or e-mail
	 * @param password User's password
	 */
	public void login(String login, String password)
	{
		try
		{
			LOG.info("Find element txt_login and send "+login);
			super.driver.findElement(By.id(super.locator.getLocator("txt_alogin", "id"))).sendKeys(login);
			LOG.info("Find element txt_password and send "+password);
			super.driver.findElement(By.id(super.locator.getLocator("txt_password", "id"))).sendKeys(password);
			LOG.info("Do a click on btn_login");
			super.driver.findElement(By.className(super.locator.getLocator("btn_login", "class"))).click();
		}
		catch (Exception ex)
		{
			LOG.fatal(ex);
			super.driver.quit();
		}
	}
	
	/**
	 * Logout from site
	 * @param LogoutType
	 */
	public void logout(String LogoutType)
	{
		try
		{
			if (LogoutType == "header")
			{
				LOG.info("Find element and click on "+super.locator.getLocator("btn_menubtn", "class"));
				driver.findElement(By.cssSelector(super.locator.getLocator("btn_menubtn", "class"))).click();
				LOG.info("Find element and click on "+super.locator.getLocator("btn_logoutMenu", "xpath"));
				driver.findElement(By.xpath(super.locator.getLocator("btn_logoutMenu", "xpath"))).click();
	
			}
			else
			{
				LOG.info("Find element and click on "+super.locator.getLocator("btn_logout", "class"));
				driver.findElement(By.className(super.locator.getLocator("btn_logout", "class"))).click();
			}
			
			LOG.info("Find element "+super.locator.getLocator("div_logout", "class"));	
			driver.findElement(By.className(super.locator.getLocator("div_logout", "class")));

		}
		catch (Exception ex)
		{
			LOG.fatal("Something went wrong "+ex);
		}
		
	}
	
}

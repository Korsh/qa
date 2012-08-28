package qa.po.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.api.Page;

public class LoginPage extends Page
{	
	/** Page file **/
	public String PAGE_URL = "/login.html";

	/** LOCATORS **/
	
	public LoginPage(WebDriver driver) 
	{
		super ();
		super.driver = driver;
	}

	/**
	 * 
	 * @param login User's screenname or e-mail
	 * @param password User's password
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void login(String login, String password)
	{	

	}
}

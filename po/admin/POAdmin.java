package qa.po.admin;


import org.openqa.selenium.WebDriver;

public class POAdmin
{	
	public LoginPage loginPage;
	
	public POAdmin (WebDriver driver)
	{
		loginPage = new LoginPage(driver);
	}
}

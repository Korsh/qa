package qa.po.benaughty;
import org.openqa.selenium.WebDriver;

public class POBenaughty
{		
	private String siteName = "benaughty";
	
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	public POBenaughty (WebDriver driver)
	{
		indexPage = new IndexPage(driver, siteName);
		loginPage = new LoginPage(driver, siteName);
		homePage = new HomePage(driver, siteName);
	}
	
}

package qa.po.benaughty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.api.Locator;
import qa.api.Page;

public class HomePage extends Page
{	
	/** Page file **/
	public String PAGE_url = "/mypage.php";
	
	public HomePage(WebDriver driver, String siteName) 
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
	public void upgrade()
	{
		driver.findElement(By.id(super.locator.getLocator("btn_upgrade", "id"))).click();
	}
}

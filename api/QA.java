package qa.api;

import qa.api.Loger;
import qa.api.Reporter;
import qa.api.SiteConfig;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import qa.api.PageObject;

public class QA 
{	    
    private File fileCH = new File(System.getProperty("user.dir")+"\\src\\qa\\lib\\driver\\chromedriver.exe");
    private File fileIE = new File("");
   
	public WebDriver driver;
	public String browser;
	public PageObject po;
	public String site;
	public SiteConfig siteConfig;
	public Loger log;
	public Reporter report;
	public String testName;
	
	/**
	 * Constructor
	 * @param browser
	 * @param projectName
	 * @param siteName
	 * @param siteBuild
	 * @param location
	 */
	public QA()
	{	

	}

	public void init(String p_browser, String p_projectName, String p_siteName, String p_siteBuild,  String p_location)
	{
		setBrowser(p_browser, p_location);

		/* Loading Site Configuration*/		
		this.siteConfig = new SiteConfig(p_projectName);
		this.site = this.siteConfig.getSiteURL(p_siteName, p_siteBuild);
		
		/* Loading Page Object*/
		this.po = new PageObject(this.driver);
		
		this.log = new Loger();
		this.report = new Reporter();

		this.log.write.info("Set browser " + browser + " Url: "+site+" Location: "+p_location);
	}

	/**
	 * Set web browser 
	 * @param browserName
	 * @param location
	 */
	@SuppressWarnings("deprecation")
	public void setBrowser(String p_browserName, String p_location)
	{
		String localProxy = getProxy(p_location);
		
		if (p_browserName.equals("firefox"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();

			Proxy proxy = new Proxy();
			proxy.setHttpProxy(localProxy);
			capabilities.setCapability("proxy", proxy);
			
			this.driver = new FirefoxDriver(capabilities);
		}
		else 
			if (p_browserName.equals("iexplorer"))
			{
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

				Proxy proxy = new Proxy();
				proxy.setHttpProxy(localProxy);
				capabilities.setCapability("proxy", proxy);
				
				System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
				this.driver = new InternetExplorerDriver(capabilities);
			}
			else 
				if (p_browserName.equals("safari"))
				{
					this.driver = new SafariDriver();
				}		
				else 
					if (p_browserName.equals("gchrome"))
					{
						if(fileCH != null)
						{	
							DesiredCapabilities capabilities = DesiredCapabilities.chrome();
							Proxy proxy = new Proxy();
							proxy.setHttpProxy(localProxy);
							capabilities.setCapability("proxy", proxy);
							System.setProperty("webdriver.chrome.driver", fileCH.getAbsolutePath());
							this.driver = new ChromeDriver(capabilities);
						}
						else
						{
							DesiredCapabilities capabilities = DesiredCapabilities.chrome();

							Proxy proxy = new Proxy();
							proxy.setHttpProxy(localProxy);
							capabilities.setCapability("proxy", proxy);
							this.driver = new ChromeDriver(capabilities);
						}
					}
	}

	/**
	 * Load page
	 * @param url
	 */
	public void loadPage(String p_url)
	{
		this.driver.get(this.site + p_url);
	}
	
	/**
	 * Wait before next action
	 * @param seconds
	 */
	public void waitFor(Integer p_seconds)
	{
		this.driver.manage().timeouts().implicitlyWait(p_seconds, TimeUnit.SECONDS);
	}

	/**
	 * Get current date
	 * @return
	 */
	public String getDate()
	{ 
		Date d = new Date();
	    DateFormat df = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
	    DateFormat r_date = new SimpleDateFormat("yyyy_MM_dd");
	    df.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
	    
		return r_date.format(d);
	}
	
	/**
	 * Get current time
	 * @return
	 */
	public String getTime()
	{
		Date r_d = new Date();
	    DateFormat df = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
	    DateFormat time = new SimpleDateFormat("HH_mm_ss");
	    df.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
	    
		return time.format(r_d);
	}

	/**
	 * Get name of log file
	 * @param testName
	 * @return logName
	 */
	public String getLogName(String p_testName)
	{
		String r_logName = p_testName+"\\"+getDate()+"\\Log_"+getTime()+".html";
		return r_logName;
	}
	
	public String getScreenName(String p_testName)
	{		
		String r_screenName = p_testName+"\\screenshots\\"+getDate()+"\\"+getTime()+".png";	
		return r_screenName;
	}

	/**
	 * Get proxy (address:port)
	 * @param location
	 * @return
	 */
	public String getProxy(String location)
	{
		String proxy = null;
		
		if ("gbr".equals(location))
		{
			proxy = "proxy-uk.cupidplc.com:3128";
		}
		else 
			if ("usa".equals(location))
			{
				proxy = "proxy-us.cupidplc.com:3128";
			}
			else 
			{
				System.out.println("Proxy server didn't set");
			}
		
		return proxy;
	}
	
	/**
	 * Take a screenshot
	 * @param testName
	 */
	public void takeScreenShot()
	{
		String testName = System.getProperty("user.dir")+"\\reports\\"+this.testName+"\\";
		String screenName = getScreenName(testName);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
			log.write.info("Screenshot has been placed to "+testName);
			FileUtils.copyFile(screenshot, new File(screenName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}

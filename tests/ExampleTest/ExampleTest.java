package qa.tests.ExampleTest;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import qa.api.QA;

public class ExampleTest
{
	public void testLogin(QA qa)
	{
		qa.loadPage(qa.po.benaughty.loginPage.PAGE_url);
		
		/*String browser = "firefox";
		String project = "general";
		String site = "benaughty";
		String build = "live";
		String location = "US";
		
		qa.init(browser, project, site, build, location);
		*/
	//	qa.init("firefox", "general", "benaughty", "live", null);
		
		
	//	qa.loadPage("/");

		/* Login from login.html */
		//qa.loadPage(qa.po.benaughty.loginPage.PAGE_url);
		//qa.po.benaughty.loginPage.login("t-jack", "1111");
		
		
		/*report*/
		/*
		HashMap<String, String> report_params = new HashMap<String, String>();
		report_params.put("test_name", "test1");
		report_params.put("site_name", "benaughty");
		report_params.put("build", "live");
		report_params.put("browser", "Firefix 14.0");
		report_params.put("locale", "es");
		report_params.put("country", "es");		
		report_params.put("gender", "male");
		report_params.put("age", "45");
		report_params.put("membership", "free");
		report_params.put("functional", "funnel");
		report_params.put("progress", "finished");
		report_params.put("status", "success");
		qa.report.createReport(report_params);
		*/
		
	//	String testName = System.getProperty("user.dir")+"\\src\\qa\\test\\"+this.getClass().getSimpleName()+"\\data\\";
	//	System.out.println(testName);
		/* Login from login.html */
		//qa.loadPage(qa.po.benaughty.loginPage.PAGE_url);
	/*	
		qa.waitFor(10);
		qa.takeScreenShot();
		qa.po.benaughty.loginPage.login("t-jack", "1111");
		
		qa.waitFor(10);
		qa.takeScreenShot();
		*/
		/*
		qa.po.benaughty.homePage.upgrade();
		
		qa.waitFor(10);
		qa.takeScreenShot(testName);
		
		qa.po.benaughty.loginPage.logout("header");
		qa.takeScreenShot(testName);
*/
		/* Login from /index.php */
	//	qa.loadPage(qa.po.benaughty.indexPage.PAGE_url);
		
		//System.out.println(qa.getSite("Benaughty"));
		//qa.po.benaughty.indexPage.login("t-jack", "1111");
		//qa.waitForLoad(10);
		//qa.po.benaughty.homePage.upgrade();
		//qa.waitForLoad(10);
	}
	
}

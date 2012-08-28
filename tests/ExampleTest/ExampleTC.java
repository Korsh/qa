package qa.tests.ExampleTest;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import qa.api.QA;

public class ExampleTC
{
	private QA qa;
	private ExampleTest ex = new ExampleTest();
	
	@Before
	public void init()
	{				
		qa = new QA();
		qa.testName = this.getClass().getSimpleName();
	}
	
	@After
	public void shutdown()
	{
		qa.driver.quit();
	}
	
	@Test
	public void testLogin()
	{
		String browser = "firefox";
		String project = "general";
		String site = "benaughty";
		String build = "live";
		String location = "US";
		
		qa.init(browser, project, site, build, location);
		ex.testLogin(qa);
		
		
	}
	
}

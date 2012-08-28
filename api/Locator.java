package qa.api;

public class Locator 
{
	private String siteName;	
	private String pageName;
	private XML xml;
	
	/**
	 * Constructor
	 * @param siteName
	 * @param pageName
	 */
	public Locator(String siteName, String pageName)
	{
		xml = new XML();
		this.siteName = siteName;
		this.pageName = pageName;
	}
	  
	/** 
	 * Get Locator
	 * @param elementType
	 * @param elementName
	 * @param locatorType
	 * @return
	 */
	public String getLocator(String elementName, String locatorType) 
	{
		String XMLPath = "locators\\" + this.siteName + "\\" + this.pageName + "Locators.xml";
		String locatorValue = xml.getValue(XMLPath, null, elementName, locatorType);
		return locatorValue;
	}	
	
}

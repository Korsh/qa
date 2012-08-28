package qa.api;

public class SiteConfig 
{
	private XML xml;
	private String XMLPath;
	
	/**
	 * Constructor
	 * @param projectName
	 */
	public SiteConfig(String projectName)
	{	
		this.xml = new XML();
		this.XMLPath = "config\\config_" + projectName + ".xml";
	}
	
	/**
	 * Get site ID
	 * @param siteName
	 * @return siteID
	 */
	public String getSiteID(String siteName)
	{	
		String siteID = xml.getValue(this.XMLPath, siteName, "site_id");
		return siteID;
	}	
	
	/**
	 * Get site URL
	 * @param siteName
	 * @param siteBuild
	 * @return
	 */
	public String getSiteURL(String siteName, String siteBuild)
	{	
		String siteURL = xml.getValue(XMLPath, siteName, "url_" + siteBuild);
		return siteURL;
	}	
	
}

package qa.api;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML 
{

	public XML ()
	{
		
	}
  

	/**
	 * Get value by Type
	 * @param path
	 * @param elementType
	 * @param elementName
	 * @param locatorType
	 * @return
	 */
	public String getValue(String path, String typeNode, String parentNode, String childNode) 
	{
		String value = null;
	  
		try 
		{	
			File xmlLocators = new File(System.getProperty("user.dir") + "\\src\\qa\\" + path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlLocators);
			doc.getDocumentElement().normalize();
 			
			NodeList nList = doc.getElementsByTagName(parentNode);
 
			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{	   
					Element eElement = (Element) nNode;
					
					if(getAttribute(childNode, eElement).equals(typeNode))
					{
						value = getNodeValue(childNode, eElement);
						temp = nList.getLength(); 
					}
					else
					{
						value = getNodeValue(childNode, eElement);
						temp = nList.getLength(); 
					}						
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	  
		return value; 
}	
	
	public String getValue(String path, String parentNode, String childNode) 
	{
		String value = null;
		value = getValue(path, null, parentNode, childNode);
		return value;
	}

	
	/**
	 * Get Locator Attribute Name
	 * @param sTag
	 * @param eElement
	 * @return
	*/
	private String getAttribute(String sTag, Element eElement) 
	{
		String attr = eElement.getAttribute("type");
		return attr;
	}

	/**
	 * Get Locator Value
	 * @param sTag
	 * @param eElement
	 * @return
	 */
	private static String getNodeValue (String childNode, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(childNode).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
}

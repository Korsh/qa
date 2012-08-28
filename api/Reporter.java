package qa.api;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


public class Reporter 
{
	private File outFile;
	private DataOutputStream outStream;
	private HashMap<String, String> report_params;
	public Reporter(){
		
	}
	
	public void createReport(HashMap<String, String> report_params) 
	{
		try 
		{
			setParams(report_params);
			createStream();
			writeHeadOfFile();
			writeBodyOfFile();
			closeStream();			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createStream()
	{
		try
	    {
	      this.outFile = new File("0908report.html");
	      this.outStream = new DataOutputStream(new FileOutputStream(outFile));
	    } 
	    catch (FileNotFoundException e)
	    {
	    	e.printStackTrace();
	    }
		
	}
	
	private void writeHeadOfFile()
	{
		try
		{
			this.outStream.writeBytes("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
	    	this.outStream.writeBytes("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
	    	this.outStream.writeBytes("<head>");
	    	  
	    	this.outStream.writeBytes("<title>" + report_params.get("test_name")+ "</title>");

			this.outStream.writeBytes("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=cp1251\" />");
			this.outStream.writeBytes("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>");
			this.outStream.writeBytes("<link rel=\"shortcut icon\"  type=\"image/x-icon\"  href=\"http://novaposhta.ua/public/images/Icon3.ico\" />");
			this.outStream.writeBytes("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://novaposhta.ua/public/css/skin.css\" />");  
	      }
	      catch (IOException e) 
	      {
				e.printStackTrace();
	      }
	}
	
	private void writeBodyOfFile()
	{
		try
		{			
			System.out.println();
			
			this.outStream.writeBytes("<div class='test_name'><h1> Test: "+report_params.get("test_name")+"<hr></h1></div>");
			this.outStream.writeBytes("<div class='site_name'><p> Site: "+report_params.get("site_name")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='build'><p> Build: "+report_params.get("build")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='browser'><p> Browser: "+report_params.get("browser")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='locale'><p> Locale: "+report_params.get("locale")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='country'><p> Country: "+report_params.get("country")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='gender'><p> Gender: "+report_params.get("gender")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='age'><p> Age: "+report_params.get("age")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='membership'><p> Membership: "+report_params.get("membership")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='functional'><p> Functional: "+report_params.get("functional")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='progress'><p> Progress: "+report_params.get("progress")+"<hr></p></div>");
			this.outStream.writeBytes("<div class='status'><p> Status: "+report_params.get("status")+"<hr></p></div>");			
		}
	    catch (IOException e) 
	    {	    	
	    	e.printStackTrace();
	    }	
	}

	private void closeStream() throws IOException
	{
		try
		{
			this.outStream.flush();
			this.outStream.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void setParams(HashMap<String, String> report_params)
	{
		this.report_params = report_params;
	}



}
package resources;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification Specreq;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(Specreq == null)
		{	
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	     
	      Specreq = new RequestSpecBuilder().setBaseUri(getGlobalValue("APTBaseURL"))
	    		    .addHeader("Authorization", getGlobalValue("Authorization"))
	    		    .setContentType(ContentType.JSON)
		            .addFilter(RequestLoggingFilter.logRequestTo(log))
	    	        .addFilter(ResponseLoggingFilter.logResponseTo(log))
	    	        .build();
	      
	      
	      return Specreq;
		}
		
		return Specreq;
		
	}
		
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\e5647787\\eclipse-workspace\\APIAutomation\\src\\test\\java\\resources\\global.properties");
		
		prop.load(fis);
		
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key)
	{
        String resp = response.asString();
	    
	    JsonPath js = new JsonPath(resp);
	    
	    return js.get(key).toString();
	}

	
}

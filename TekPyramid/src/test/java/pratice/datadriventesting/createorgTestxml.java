package pratice.datadriventesting;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class createorgTestxml {
     @Test 
     public void createorgtest(XmlTest test)throws Throwable{
    	//read common data from JSON file
     	
      	JSONParser parser = new JSONParser();
      	Object obj = parser.parse(new FileReader("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\appcommonData.json"));
      	JSONObject map = (JSONObject)obj;
      	
      	String URL = test.getParameter("url");
      	String BROWSER = test.getParameter("browser");
      	String USERNAME = test.getParameter("username");
      	String PASSWORD = test.getParameter("password");
     }
}
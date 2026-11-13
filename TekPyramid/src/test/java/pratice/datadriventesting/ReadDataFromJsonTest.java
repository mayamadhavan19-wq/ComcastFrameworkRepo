package pratice.datadriventesting;



import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.json.JsonException;

public class ReadDataFromJsonTest {
    public static void main(String[] args) throws Throwable, JsonException, FileNotFoundException {
		//step 1: Parse JSON physical file in to java object using JSONparse class
    	JSONParser parser = new JSONParser();
    	Object obj = parser.parse(new FileReader("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\appcommonData.json"));
    	//Step 2:Convert java object in to JSONobject using downcasting
    	JSONObject map = (JSONObject)obj;
    	System.out.println(map.get("url"));
    	System.out.println(map.get("browser"));
    	System.out.println(map.get("Username"));
    	System.out.println(map.get("Password"));
    	System.out.println(map.get("timeout"));
    	
	}
}
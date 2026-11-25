package pratice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class jsonexample {
@Test(enabled=false)
public void m1() throws Throwable, IOException, ParseException
{
	JSONParser parse=new JSONParser();
	Object obj=parse.parse(new FileReader("‪"));
	JsonObject jobj=(JsonObject)obj;
	System.out.println(jobj.get("browser"));
}
@Test
public void JsonData() throws FileNotFoundException, IOException, ParseException
{
	JSONParser js=new JSONParser();
	JSONObject jo=(JSONObject)js.parse(new FileReader(""));
	System.out.println("BROWSER:"+jo.get("browser"));
	System.out.println("url:"+jo.get("url"));
}
}

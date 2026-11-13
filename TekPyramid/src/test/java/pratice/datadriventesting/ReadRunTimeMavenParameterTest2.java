package pratice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest2 {
   @Test
   public void runtimeparameterTest() {
	   String URL = System.getProperty("url");
	   String BROWSER = System.getProperty("browser");
	   String USERNAME = System.getProperty("Username");
	   String PASSWORD = System.getProperty("Password");
	   
	   System.out.println("Env Data==>URL====>"+URL);
	   System.out.println("Browser Data==> ====>"+BROWSER);
	   System.out.println("Username Data==> ====>"+USERNAME);
	   System.out.println("Password Data==> ====>"+PASSWORD);
   }
}
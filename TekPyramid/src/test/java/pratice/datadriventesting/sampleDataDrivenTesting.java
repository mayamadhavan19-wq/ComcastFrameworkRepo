package pratice.datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

public class sampleDataDrivenTesting {
	public static void main(String[] args) throws Throwable {
		 //Step 1:get the java representation object of the physical file
		 FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Downloads\\Selenium-Workspace\\Selenium-Workspace\\selenium_project\\commomdata.properties") ;
		 
		 //step 2 :Using properties class,load all the keys
		 Properties pobj = new Properties();
		 pobj.load(fis);
		 
		 //step 3:get the value based on key
		 System.out.println(pobj.getProperty("browser"));
		 
	}
}
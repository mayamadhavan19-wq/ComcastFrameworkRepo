package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class createOrgtestjson {
     @Test
     public void createOrgtest() throws Throwable{
    	//read common data from JSON file
    	
     	JSONParser parser = new JSONParser();
     	Object obj = parser.parse(new FileReader("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\appcommonData.json"));
     	JSONObject map = (JSONObject)obj;
     	
     	
     	String BROWSER = map.get("browser").toString();
     	String URL = map.get("url").toString();
     	String USERNAME = map.get("Username").toString();
     	String PASSWORD = map.get("Password").toString();
     	
     	//Read testscript data from Excel file
     	FileInputStream fis1 = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
     	Workbook wb = WorkbookFactory.create(fis1);
     	Sheet sh = wb.getSheet("org");
     	Row row = sh.getRow(1);
     	String orgName = row.getCell(2).toString();
     	wb.close();
     	
     	WebDriver driver = null;
     	if(BROWSER.equals("chrome")) {
     		driver = new ChromeDriver();
     	}else if(BROWSER.equals("firefox")) {
     		driver = new FirefoxDriver();
     	}else if(BROWSER.equals("edge")) {
     		driver = new EdgeDriver();
     	}else {
     		driver = new ChromeDriver();
     	}
     	
     	//step 1 : login to app
     	driver.get(URL);
     	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
     	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
     	driver.findElement(By.id("submitButton")).click();
     	//step 2: navigate to organization module
      	driver.findElement(By.linkText("Organizations")).click();
     	//step 3: Click on "create organization" button
     	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();    
     	//Step 4:Enter all the details & create new organization
     	driver.findElement(By.name("accountname")).sendKeys("facebook1");
      	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     	//step 5:logout
     	Actions act = new Actions(driver);
     	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
     	driver.findElement(By.linkText("Sign Out")).click();
     }
}
package pratice.datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GenerateRandomNumtest {
	public static void main(String[] args) throws Throwable {
		//read common data from properties file
    	FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Downloads\\Selenium-Workspace\\AdvSelA24\\commondata.properties");
    	Properties pobj = new Properties();
    	pobj.load(fis);
    	
    	String BROWSER = pobj.getProperty("browser");
    	String URL = pobj.getProperty("Url");
    	String USERNAME = pobj.getProperty("Username");
    	String PASSWORD = pobj.getProperty("Password");
    	
    	//Generate the random number
    	Random random = new Random();
    	int randomInt = random.nextInt(1000);
    	
    	//Read testscript data from Excel file
    	FileInputStream fis1 = new FileInputStream("C:\\Users\\Sathishkumar\\Desktop\\Tekpyramid\\testscriptdata.xlsx");
    	Workbook wb = WorkbookFactory.create(fis1);
    	Sheet sh = wb.getSheet("org");
    	Row row = sh.getRow(1);
    	String orgName = row.getCell(2).toString()+randomInt;
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
package Com.ComCast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Test case : 1
//Navigate to application
//Login to application
//Navigate to organization
//Navigate to "Create new organization" page by click on "+" image
//Create a organization with mandatory fields
//logout
public class CreateOrganizationTest {
   public static void main(String[] args) throws Throwable {
	//Read common data from properties file
	FileInputStream fis = new FileInputStream("C:\\Users\\mayam\\OneDrive\\Documents\\Programe\\TekPyramid\\configappdata\\commondata.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("Url");
	String USERNAME = pobj.getProperty("Username");
	String PASSWORD = pobj.getProperty("Password");
	
	//Generate the Random Number
	Random random = new Random();
	int randomInt = random.nextInt(40000);
	//Read testscript data from Excel file
	FileInputStream fis1 = new FileInputStream("‪C:\\Users\\mayam\\Downloads\\Org.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(1);
	String orgName = row.getCell(2).toString() + randomInt;
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//step 2: navigate to organization module
 	driver.findElement(By.linkText("Organizations")).click();
	//step 3: Click on "create organization" button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();    
	//Step 4:Enter all the details & create new organization
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Verify Header msg Expected Result
	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerInfo.contains(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}else {
		System.out.println(orgName+" is not created==FAIL");
	}
	//Verify Header orgName info Expected Result
	String actorgName =driver.findElement(By.id("dtlview_Organization Name ")).getText();
	if(actorgName.equals(orgName)) {
		System.out.println(orgName+" information is created==PASS");
	}else {
		System.out.println(orgName+" information is not created==FAIL");
	}
	//step 5:logout
	Actions act = new Actions(driver);
	Thread.sleep(2000);
	WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Thread.sleep(2000);
	act.moveToElement(admin).perform();
			driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
}
}
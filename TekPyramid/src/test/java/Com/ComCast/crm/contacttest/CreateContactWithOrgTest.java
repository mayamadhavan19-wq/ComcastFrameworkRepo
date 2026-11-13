package Com.ComCast.crm.contacttest;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

//Test case : 6
//Navigate to application
//Login to application
//Place the mouse cursor and click on "contact" link
//Navigate to "Create new contact" page by click on "+" image
//Create a contact without mandatory fields
//Click on organization Name lookup image "+"
//Search for organization & select the same
//Click on save
//logout
public class CreateContactWithOrgTest {
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
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString() + randomInt;
		String contactLastName = row.getCell(3).getStringCellValue();
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
			System.out.println(orgName+" header verified==PASS");
		}else {
			System.out.println(orgName+" header is not created==FAIL");
		}
		//step 5: navigate to organization module
     	driver.findElement(By.linkText("Contacts")).click();
    	//step 6: Click on "create organization" button
    	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();    
    	//Step 7:Enter all the details & create new organization
    	driver.findElement(By.name("lastname")).sendKeys(contactLastName);
    	driver.findElement(By.xpath("//input[@type='text']/following-sibling::img")).click();
    	
    	//Switch to child window
    	Set<String> set = driver.getWindowHandles();
    	Iterator<String> it = set.iterator();
    	while(it.hasNext()) {
    		String windowID = it.next();
    		driver.switchTo().window(windowID);
    		String actUrl = driver.getCurrentUrl();
    		if(actUrl.contains("module=Accounts")) {
    			break;
    		}
    	}
    	
    	driver.findElement(By.name("search_text")).sendKeys(orgName);
    	driver.findElement(By.name("search")).click();
    	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
    	
    	//Switch to parent window
    	Set<String> set1 = driver.getWindowHandles();
    	Iterator<String> it1 = set1.iterator();
    	while(it1.hasNext()) {
    		String windowID = it1.next();
    		driver.switchTo().window(windowID);
    		String actUrl = driver.getCurrentUrl();
    		if(actUrl.contains("Contacts&action")) {
    			break;
    		}
    	}
    	
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	
		//Verify Header orgName info Expected Result
         headerInfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName+" header verified==PASS");
		}else {
			System.out.println(contactLastName+" header is not verified==FAIL");
		}
		
		//Verify Header orgName info Expected Result
        String actOrgName =driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+" information is created==PASS");
		}else {
			System.out.println(orgName+" information is not created==FAIL");
		}
		
		driver.quit();
	}
}
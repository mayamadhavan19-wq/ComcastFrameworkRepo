package Com.ComCast.crm.contacttest;

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

//Test case : 4
//Navigate to application
//Login to application
//Place the mouse cursor and click on "contact" link
//Navigate to "Create new contact" page by click on "+" image
//Create a contact without mandatory fields and save 
//logout
public class CreateContactTest {
	public static void main(String[] args) throws Throwable {
		//Read the common data from JSON File
    	FileInputStream fis = new FileInputStream("C:\\Users\\mayam\\OneDrive\\Documents\\Programe\\TekPyramid\\configappdata\\commondata.properties");
    	Properties pobj = new Properties();
    	pobj.load(fis);
    	
    	String BROWSER = pobj.getProperty("browser");
    	String URL = pobj.getProperty("Url");
    	String USERNAME = pobj.getProperty("Username");
    	String PASSWORD = pobj.getProperty("Password");
    	
    	//Generate the Random Number
    	Random random = new Random();
    	int randomInt = random.nextInt(1000);
    	//Read testscript data from Excel file
    	FileInputStream fis1 = new FileInputStream("‪C:\\Users\\mayam\\Downloads\\Org.xlsx");
    	Workbook wb = WorkbookFactory.create(fis1);
    	Sheet sh = wb.getSheet("contact");
    	Row row = sh.getRow(1);
    	String lastName = row.getCell(2).toString()+randomInt;
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
     	driver.findElement(By.linkText("Contacts")).click();
    	//step 3: Click on "create organization" button
    	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();    
    	//Step 4:Enter all the details & create new organization
    	driver.findElement(By.name("lastname")).sendKeys(lastName);
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	
    	//Verify lastname info Expected Result
    	String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
    	if(actLastName.equals(lastName)) {
    		System.out.println(lastName+" information is verified==PASS");
    	}else {
    		System.out.println(lastName+" information is not verified==FAIL");
    	}
    	
    	//Step 5:logout
    	driver.quit();
	}
}
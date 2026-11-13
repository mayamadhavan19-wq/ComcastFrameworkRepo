package Com.ComCast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.creatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organizationInfoPage;
import com.comcast.crm.objectrepositoryutility.organizationPage;

import Com.ComCast.crm.basetest.BaseClass;
//Test case : 5
//Navigate to application
//Login to application
//Place the mouse cursor and click on "contact" link
//Navigate to "Create new contact" page by click on "+" image
//Create a contact with support startDate & EndDate 
//logout
public class CreateContactWithSupportDate {
	public static void main(String[] args) throws Throwable {
		//Read the common data from JSON File
    	FileInputStream fis = new FileInputStream("C:\\\\Users\\\\mayam\\\\OneDrive\\\\Documents\\\\Programe\\\\TekPyramid\\\\configappdata\\\\commondata.properties");
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
    	FileInputStream fis1 = new FileInputStream("C:\\\\Users\\\\mayam\\\\Downloads\\\\Org.xlsx");
    	Workbook wb = WorkbookFactory.create(fis1);
    	Sheet sh = wb.getSheet("contact");
    	Row row = sh.getRow(4);
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
    	
    	Date dateObj = new Date();
    	SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
    	String startDate = sim.format(dateObj);
    	
    	Calendar cal = sim.getCalendar();
    	cal.add(Calendar.DAY_OF_MONTH, 30);
    	String endDate = sim.format(cal.getTime());
    	
    	driver.findElement(By.name("lastname")).sendKeys(lastName);
    	driver.findElement(By.name("support_start_date")).clear();
    	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
    	driver.findElement(By.name("support_end_date")).clear();
    	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	
    	//Verify lastname info Expected Result
    	String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
    	if(actStartDate.equals(startDate)) {
    		System.out.println(startDate+" information is verified==PASS");
    	}else {
    		System.out.println(startDate+" information is not verified==FAIL");
    	}
    	String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
    	if(actEndDate.equals(endDate)) {
    		System.out.println(endDate+" information is verified==PASS");
    	}else {
    		System.out.println(endDate+" information is not verified==FAIL");
    	}
    	//Step 5:logout
    	driver.quit();
}
}

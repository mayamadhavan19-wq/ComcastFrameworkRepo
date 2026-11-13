package Com.ComCast.crm.basetest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.geneic.webdriverutility.JavaUtility;
import com.comcast.crm.geneic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileulitity.ExcelUtility;
import com.comcast.crm.generic.fileulitity.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.loginPage;


public class BaseClass {
	/*create object*/
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib= new  WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws Throwable {
		System.out.println("===Connect to DB , Report config===");
		dLib.getDbConnection();
		
		//spark report config
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add environment information and create test
			    report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows-10");
				report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(String browser) throws Throwable {
		System.out.println("Launch the browser");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		//String BROWSER = browser;
		//driver = null;
    	if(BROWSER.equals("chrome")) {
    		driver = new ChromeDriver();
    	}else if(BROWSER.equals("firefox")) {
    		driver = new FirefoxDriver();
    	}else if(BROWSER.equals("edge")) {
    		driver = new EdgeDriver();
    	}else {
    		driver = new ChromeDriver();
    	}
    	sdriver=driver;
    	//System.out.println("==Launch the browser==");
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("login");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		loginPage lp = new loginPage(driver);
		//wLib.waitForPageToLoad(driver);
		lp.loginToapp(URL,USERNAME,PASSWORD );
		//System.out.println("=login=");
    }
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() throws Throwable {
		System.out.println("homepage");
		HomePage hp = new HomePage(driver);
		hp.logout();
		//System.out.println("=logout=");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		
		System.out.println("==close the browser==");
		driver.quit();
	}
	
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("===close DB , Report backUP===");
		dLib.closeDbConnection();
		
		report.flush();
	}
	
	 
}
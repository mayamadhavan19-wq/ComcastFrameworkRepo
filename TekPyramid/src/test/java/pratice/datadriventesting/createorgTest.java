package pratice.datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class createorgTest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Sathishkumar\\Downloads\\Selenium-Workspace\\Selenium-Workspace\\selenium_project\\commomdata.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("Url");
		String USERNAME = pobj.getProperty("Username");
		String PASSWORD = pobj.getProperty("Password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Support Center")).click();
		//driver.quit();
	}
}
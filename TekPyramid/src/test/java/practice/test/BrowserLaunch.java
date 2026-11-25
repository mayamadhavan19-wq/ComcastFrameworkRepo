package practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLaunch {
	WebDriver driver=null;
@Test
public void browserLaunch() throws InterruptedException {
	String browser = System.getProperty("browser");
	System.out.println(browser);
		if(browser.equals("chrome")){
			driver = new ChromeDriver();	
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		
        driver.get(System.getProperty("url"));
		}
		Thread.sleep(2000);
		driver.quit();
}
}

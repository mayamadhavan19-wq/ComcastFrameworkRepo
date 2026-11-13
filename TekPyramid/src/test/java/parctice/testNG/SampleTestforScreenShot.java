package parctice.testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestforScreenShot {
@Test
public void amazonTest() throws IOException
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in");
	//create an object to event firing webdriver
	TakesScreenshot ts=(TakesScreenshot)driver;
	//use getScreenshotAs() to get file type of screenshot
	File src=ts.getScreenshotAs(OutputType.FILE);
	//store screenshot in local drive
	FileUtils.copyFile(src, new File("./Screenshot/test.png"));
}
}

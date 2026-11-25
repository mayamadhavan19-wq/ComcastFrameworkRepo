package pratice.datadriventesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShadowRoot {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
	
	//open>close
/*	SearchContext host=driver.findElement(By.xpath("//div[@class='shadowOuter']")).getShadowRoot();
	Actions act=new Actions(driver);
	act.sendKeys(driver.findElement(By.xpath("//h1[text()='Login']")),Keys.TAB,"sdsdf").perform();
	act.sendKeys(host.findElement(By.cssSelector("label[for='email']")),Keys.TAB,"hii").perform();
	Thread.sleep(2000);
	*/
	
	//close>open
	Actions act=new Actions(driver);
	//act.sendKeys(driver.findElement(By.xpath("//h1[text()='Login']")),Keys.TAB,"hiii").perform();
	act.sendKeys(driver.findElement(By.xpath("//h1[text()='Login']")),Keys.TAB,"jdkss").perform();
	Thread.sleep(2000);
	driver.quit();
}
}

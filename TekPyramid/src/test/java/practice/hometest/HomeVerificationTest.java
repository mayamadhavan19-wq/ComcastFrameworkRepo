package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomeVerificationTest {
@Test
public void homepageTest(Method mtd)
{
	System.out.println(mtd.getName()+"Test Start");
	String expectedpage="Home";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.29.4:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	String acttittle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	
	/*
	 * if(acttittle.trim().equals(expectedpage)) {
	 * System.out.println(expectedpage+"page is verified==PASS"); }else {
	 * System.out.println(expectedpage+"page is verified==FAIL");
	 * 
	 * }
	 */
	//Hard Assert
	Assert.assertEquals(acttittle, expectedpage);
	
	 driver.close();
	 System.out.println(mtd.getName()+"Test End");
	 
}
@Test
public void VerifyLogoTest(Method mtd)
{
	System.out.println(mtd.getName()+"Test Start");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.29.4:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	boolean status=driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
	/*if(status)
	{
		System.out.println("logo is verified==PASS");
	}else
	{
		System.out.println("logo is verified==FAIL");

	}*/
	//Hard Assert
	//Assert.assertEquals(true,status);
	Assert.assertTrue(status);
	
	driver.close();
	System.out.println(mtd.getName()+"Test End");

	
}
}

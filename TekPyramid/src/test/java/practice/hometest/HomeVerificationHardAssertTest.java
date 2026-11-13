package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeVerificationHardAssertTest {
	@Test
	public void homepageTest(Method mtd)
	{
	System.out.println(mtd.getName()+"Test Start");
	System.out.println("Step-1");
	System.out.println("Step-2");
	Assert.assertEquals("Home", "Home");
	System.out.println("Step-3");
	Assert.assertEquals("Home-CRM", "Home-CRM");
	System.out.println("Step-4");
	 System.out.println(mtd.getName()+"Test End");
	 
}
	@Test
	public void VerifyLogoTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+"Test End");

		
	}
}

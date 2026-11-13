package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeVerificationSoftAssertTest {
	@Test
	public void homepageTest(Method mtd)
	{
	System.out.println(mtd.getName()+"Test Start");
	SoftAssert assertobj=new SoftAssert();
	System.out.println("Step-1");
	System.out.println("Step-2");
	//assertobj.assertEquals("Home", "Home");
	Assert.assertEquals("Home", "Home-page");
	System.out.println("Step-3");
	//assertobj.assertEquals("Home-CRM", "Home-CRM");
	assertobj.assertEquals("Title", "Title");
	System.out.println("Step-4");
	assertobj.assertAll();
	 System.out.println(mtd.getName()+"Test End");
	 
}
	@Test
	public void VerifyLogoTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test Start");
		SoftAssert assert1=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		assert1.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		assert1.assertAll();
		System.out.println(mtd.getName()+"Test End");

		
	}
}

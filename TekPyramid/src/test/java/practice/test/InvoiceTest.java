package practice.test;

//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.ComCast.crm.basetest.BaseClass;
import junit.framework.Assert;
//@Listeners(com.comcast.crm.listnerutility.ListnerImplementationClass.class)
public class InvoiceTest extends BaseClass {
	@Test
	public void CreateInvoiceTest() {
		System.out.println("execute CreateInvoiceTest");
		// String var=driver.getTitle();
		// System.out.println(var);
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle, "Login");
		System.out.println("Step=1");
		System.out.println("Step=2");
		System.out.println("Step=3");
		System.out.println("Step=4");
	}

	@Test
	public void CreateInvoiceWithContactTest() {
		System.out.println("execute CreateInvoiceWithContactTest");
		System.out.println("Step=1");
		System.out.println("Step=2");
		System.out.println("Step=3");
		System.out.println("Step=4");
	}
}

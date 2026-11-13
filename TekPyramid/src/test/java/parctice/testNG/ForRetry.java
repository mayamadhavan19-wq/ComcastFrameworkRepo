package parctice.testNG;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class ForRetry{
	@Test(retryAnalyzer=com.comcast.crm.listnerutility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("activating sim");
		Assert.assertEquals("", "Login");
		System.out.println("Step=1");
		System.out.println("Step=2");
		System.out.println("Step=3");
		System.out.println("Step=4");
	}

}

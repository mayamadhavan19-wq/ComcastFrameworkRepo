package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;


import com.comcast.crm.basetest.BaseClass;

/**
 * test class for contact module
 * @author mayam
 */
public class SearchContactTest extends BaseClass {
	/**
	 * Scenario : login()==>navigateContact==>createContact()==>verify
	 * 
	 */
@Test
public void searchcontactTest()
{
	/*step 1: login to app*/
	LoginPage lp=new LoginPage(driver);
		lp.loginToapp("url", "username", "password");	
}
}

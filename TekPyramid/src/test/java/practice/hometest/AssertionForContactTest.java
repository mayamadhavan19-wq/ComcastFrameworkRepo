package practice.hometest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.creatingNewOrganizationPage;

import Com.ComCast.crm.basetest.BaseClass;
import CreatingNewContactPage.CreatingNewContactPage;
import contactPage.ContactPage;

public class AssertionForContactTest extends BaseClass {
	@Test
	public void createContactTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();
		// step 3: Click on "create organization" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();
		// Step 4:Enter all the details & create new organization
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);
		// Verify lastname info Expected Result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information is not verified==FAIL");
		}

	}

	@Test
	public void createContactWithSupportDateTest() throws Throwable {
		// read testscript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		// Step 2: navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// Step 3: Click on "create contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// Step 4 : Enter all the details & create new contact
		String endDate = jLib.getSystemDateYYYYDDMM();
		String startDate = jLib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// Verify Header phone Number info Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information is not verified==FAIL");
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " information is verified==PASS");
		} else {
			System.out.println(endDate + " information is not verified==FAIL");
		}
//		    	//Step 5:logout
//		    	driver.quit();
	}

	@Test
	public void createContactWithOrgTest() throws Throwable {
		WebDriver driver = null;

		// Read testScript data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create organization" button
		com.comcast.crm.objectrepositoryutility.creatingNewOrganizationPage cnp = new com.comcast.crm.objectrepositoryutility.creatingNewOrganizationPage(
				driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details & create new organization
		creatingNewOrganizationPage cnop = new com.comcast.crm.objectrepositoryutility.creatingNewOrganizationPage(
				driver);
		cnop.createOrg(orgName);

		// Step 5: navigate to Contact module
		hp.getContactlnk().click();

		// Step 6: Click on "create contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();

		// Step 7 :Enter all the details & create new Contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactwithOrg(contactLastName, orgName);

		// Verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea-organizationName")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + " information is not created==FAIL");
		}
	}
}

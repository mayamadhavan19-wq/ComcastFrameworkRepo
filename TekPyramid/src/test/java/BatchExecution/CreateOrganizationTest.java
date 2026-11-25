package BatchExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.geneic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listnerutility. ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrgTest() throws Throwable {

		// Read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		
		// step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		
		UtilityClassObject.getTest().log(Status.INFO,"create a new org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// Verify Header msg Expected Result
		UtilityClassObject.getTest().log(Status.INFO,orgName+ "===>create a new org");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderTxt().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified == PASS");
		} else {
			System.out.println(orgName + " name is not verified == FAIL");
		}

	}

	@Test
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		// read testscript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

		// Step 2: navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "create organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNumber);

		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + " information is created==PASS");
		} else {
			System.out.println(phoneNumber + " information is not created==FAIL");
		}
//		    	//Step 5:logout
//		    	driver.quit();
	}

	@Test
	public void createOrgWithIndustriesTest() throws Throwable {
		WebDriver driver = null;

		// Read testScript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// Verify the industries and type info
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.equals(industry)) {
			System.out.println(industry + " information is verified==PASS");
		} else {
			System.out.println(industry + " information is not verified==FAIL");
		}
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is verified==PASS");
		} else {
			System.out.println(type + " information is not verified==FAIL");
		}
	}
}

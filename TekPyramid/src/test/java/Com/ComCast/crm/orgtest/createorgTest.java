package Com.ComCast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.geneic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

//Navigate to application https://localhost:8888
//login to application admin /tiger
//navigate to organization
//Organization page click on "+" image
//create organization with mandatory fields  laptop names
//logout

@Listeners(com.comcast.crm.listnerutility.ListenerImplementation.class)
public class createorgTest  extends BaseClass{
@Test
public void createOrgTest() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
	
	String orgName = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
	
	UtilityClassObject.getTest().log(Status.INFO," navigate to org page");
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();
	
	UtilityClassObject.getTest().log(Status.INFO," navigate to create org page");
	OrganizationsPage cnp = new OrganizationsPage(driver);
	cnp.getCreateNewOrgBtn().click();
	
	UtilityClassObject.getTest().log(Status.INFO," create a new org");
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	
	UtilityClassObject.getTest().log(Status.INFO,"  ===>Create a new Org");
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String actOrgName = oip.getHeaderTxt().getText();
	
	Assert.assertEquals(true, actOrgName.contains(orgName));	
	
}

@Test
public void createOrgwithPhoneNumberTest() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
	String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
	String phoneNumber = eLib.getDataFromExcel("org", 7, 3)+jLib.getRandomNumber();
	
	UtilityClassObject.getTest().log(Status.INFO," create a new org");
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationsPage cnp = new OrganizationsPage(driver);
	cnp.getCreateNewOrgBtn().click();
	
	UtilityClassObject.getTest().log(Status.INFO," create a new org with phone Number");
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName, phoneNumber);
	
	UtilityClassObject.getTest().log(Status.INFO," verify the org Name and  phone number ");
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String actOrgName = oip.getHeaderTxt().getText();
	Assert.assertEquals(true, actOrgName.contains(orgName));
	
	String actPhoneNumber = oip.getPhoneNumInfo().getText();
	Assert.assertEquals(actPhoneNumber, phoneNumber);
	
}
}
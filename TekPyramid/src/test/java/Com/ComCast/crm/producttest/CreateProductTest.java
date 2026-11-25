package Com.ComCast.crm.producttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.comcast.crm.geneic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

import com.comcast.crm.basetest.BaseClass;
import CreatingNewContactPage.CreatingNewContactPage;
import contactPage.ContactPage;
@Listeners(com.comcast.crm.listnerutility.ListenerImplementation.class)
public class CreateProductTest extends BaseClass{
@Test(groups = "system")
public void createProductTest() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO,"read product Name from excel");
	String productName = eLib.getDataFromExcel("title", 1, 2)+jLib.getRandomNumber();
	
	HomePage hp = new HomePage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO, "Clicking on product link");
	hp.getProductsLink().click();
	
	ProductsPage pp = new ProductsPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Click on new product icon");
	pp.getCreateProductBtn().click();
	
	CreatingNewProductPage cnpp = new CreatingNewProductPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Enter product name");
	cnpp.getProductnameTxt().sendKeys(productName);
	
	UtilityClassObject.getTest().log(Status.INFO,"Click on save Btn");
	cnpp.getSaveBtn().click();
	
	ProductInformationPage pip = new ProductInformationPage(UtilityClassObject.getDriver());
	
	String actProductName = pip.getProductNameTbl().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Table");
	Assert.assertTrue(actProductName.contains(productName));
	
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Header");
	String actProductHeaderText = pip.getProductHeaderTxt().getText();
	Assert.assertTrue(actProductHeaderText.contains(productName));
	
	
	
}
}
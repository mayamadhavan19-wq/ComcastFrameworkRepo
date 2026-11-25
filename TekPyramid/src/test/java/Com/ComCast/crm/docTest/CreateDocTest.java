package Com.ComCast.crm.docTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.geneic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateNewDocPage;
import com.comcast.crm.objectrepositoryutility.DocInfoPage;
import com.comcast.crm.objectrepositoryutility.DocumentPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(com.comcast.crm.listnerutility.ListenerImplementation.class)

public class CreateDocTest extends BaseClass {
	@Test
	public void createDocTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read document title from excel");
		String docName = eLib.getDataFromExcel("Sheet1", 1, 1) + jLib.getRandomNumber();

		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on document link");
		hp.getdocumentlLink().click();
		
		DocumentPage dp=new DocumentPage(UtilityClassObject.getDriver());
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on new document icon");
		dp.getcreateDoc().click();
		
		CreateNewDocPage cnd = new CreateNewDocPage(UtilityClassObject.getDriver());
		UtilityClassObject.getTest().log(Status.INFO,"Enter title");
		cnd.getTitle().sendKeys(docName);
		
		UtilityClassObject.getTest().log(Status.INFO,"Click on save Btn");
		cnd.getsaveBtn().click();
		
		DocInfoPage dip=new DocInfoPage(UtilityClassObject.getDriver());
		String actDocName = dip.gettitletxt().getText();
		UtilityClassObject.getTest().log(Status.INFO,"Verifying document name with table");
		Assert.assertTrue(actDocName.contains(docName));
		
		UtilityClassObject.getTest().log(Status.INFO,"Verifying document name with Header");
		String actProductHeaderText = dip.getheadertxt().getText();
		Assert.assertTrue(actProductHeaderText.contains(docName));
	}
}

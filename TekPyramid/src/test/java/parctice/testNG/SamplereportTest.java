package parctice.testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.ComCast.crm.basetest.BaseClass;

public class SamplereportTest {
	ExtentReports report;
	@BeforeSuite
	public void conficBS() {
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment information and create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
@Test
public void createcontactTest()
{
	/*
	 * //spark report config ExtentSparkReporter spark=new
	 * ExtentSparkReporter("./AdvanceReport/report.html");
	 * spark.config().setDocumentTitle("CRM Test Suite Results");
	 * spark.config().setReportName("CRM Report");
	 * spark.config().setTheme(Theme.DARK);
	 * 
	 * //add environment information and create test ExtentReports report=new ExtentReports();
	 *  report.attachReporter(spark); report.setSystemInfo("OS","Windows-10");
	 *   report.setSystemInfo("BROWSER", "CHROME-100");
	 */
	ExtentTest test=report.createTest("createcontactTest");
	
    test.log(Status.INFO,"login to page");
    test.log(Status.INFO,"navigate to contact page");
    test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
		{
		test.log(Status.PASS,"contact is created ");
		}
	else {
		test.log(Status.FAIL,"contact is not created");
	}
	//report.flush();
	System.out.println("login to app");
}
@Test
public void createcontactWithOrg()
{
	ExtentTest test=report.createTest("createcontactTest");
	
    test.log(Status.INFO,"login to page");
    test.log(Status.INFO,"navigate to contact page");
    test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
		{
		test.log(Status.PASS,"contact is created ");
		}
	else {
		test.log(Status.FAIL,"contact is not created");
	}

	System.out.println("login to app");
}
@Test
public void createcontactWithPhone()
{
	ExtentTest test=report.createTest("createcontactTest");
	
    test.log(Status.INFO,"login to page");
    test.log(Status.INFO,"navigate to contact page");
    test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
		{
		test.log(Status.PASS,"contact is created ");
		}
	else {
		test.log(Status.FAIL,"contact is not created");
	}
	System.out.println("login to app");
}
}



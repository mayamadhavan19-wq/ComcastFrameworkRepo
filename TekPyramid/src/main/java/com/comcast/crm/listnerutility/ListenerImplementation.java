package com.comcast.crm.listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.geneic.webdriverutility.UtilityClassObject;



public class ListenerImplementation implements ITestListener, ISuiteListener{

	
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println( "Report configuration ");
		com.comcast.crm.geneic.webdriverutility.JavaUtility jLib = new com.comcast.crm.geneic.webdriverutility.JavaUtility();
		String time=jLib.getSystemDateYYYYDDMM();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM report");
			spark.config().setTheme(Theme.DARK);
			
			//add env info and create test 
			 report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println( "Report backup ");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println( "==== "+result.getMethod().getMethodName()+"===START===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"==STARTED==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println( "==== "+result.getMethod().getMethodName()+"===END===");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==COMPLETED==");

	}

	@Override
	public void onTestFailure(ITestResult result) {
	String testName = result.getMethod().getMethodName();
	TakesScreenshot ts = (TakesScreenshot)UtilityClassObject.getDriver();
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			String time1 = new Date().toString().replace(" ", "_").replace(".", "_");
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+time1+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TakesScreenshot edriver = (TakesScreenshot)UtilityClassObject.getDriver();
		String filePath = edriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(".", "_");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, testName+"==FAILED==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		report.flush();
	}

	
}
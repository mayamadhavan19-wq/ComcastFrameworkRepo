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
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener,ISuiteListener {
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
public void onStart(ISuite suite)
{
	System.out.println("Report configuration");
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

public void onFinish(ISuite suite)
{
	System.out.println("Report Backup");
	report.flush();
}
public void onTestStart(ITestResult result)
{
	System.out.println("====>"+result.getMethod().getMethodName()+"<=====START=====");
}
public void onTestSuccess(ITestResult result)
{
	System.out.println("====>"+result.getMethod().getMethodName()+"<=====END=====");
}
public void onTestFailure(ITestResult result, TakesScreenshot driver)
{
	String TestName=result.getMethod().getMethodName();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String time=new Date().toString().replace(" ","_").replace(":","_");
	try {
	FileUtils.copyFile(src, new File("./Screenshot/"+TestName+"+"+time+".png"));
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}
public void onTestSkipped(ITestResult result)
{
	
}
public void onTestFailedButWithinSuccessPercentage(ITestResult result)
{
	
}
}

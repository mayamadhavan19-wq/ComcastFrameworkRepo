package practicesession;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener,ISuiteListener {

public void OnStart(ISuite s)
{
	System.out.println("OnStart mathod for suite is executing");
}
public void OnStart(ITestContext c)
{
	System.out.println("OnStart mathod for <test> tag is executing");
}
public void OnTestStart(ITestResult r)
{
	System.out.println("OnStart mathod for @Test gets Started");
}
public void OnTestSuccess(ITestResult r)
{
	System.out.println("Passed Test case");
}
public void OnTestFailure(ITestResult r)
{
	System.out.println("Failed Test case");
}
public void OnTestSkipped(ITestResult r)
{
	System.out.println("Skipped testcase");
}
public void OnTestFailureWithinSuccessPercentage(ITestResult r)
{
	System.out.println("Failed percentage");
}
public void OnTestFailureWithTimeouts(ITestResult r)
{
	System.out.println("timeout");
}
public void OnTestFinish(ITestResult r)
{
	System.out.println("OnFinish mathod for @Test is executing");
}
public void OnFinish(ITestContext c)
{
	System.out.println("OnFinish mathod for <test> tag is executing");
}
public void OnFinish(ISuite s)
{
	System.out.println("OnFinish mathod for suite is executing");
}

}

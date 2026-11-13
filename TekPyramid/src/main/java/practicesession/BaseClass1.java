package practicesession;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass1 {
@BeforeSuite(alwaysRun=true)
public void BS()
{
	System.out.println("Before Suite starts executing");
}
@BeforeTest(groups= {"smokeTest","regressionTest"})
public void BT()
{
	System.out.println("Before Test starts executing");
}
@BeforeClass(groups="smokeTest")
public void BC()
{
	System.out.println("Before class starts executing");
}
@BeforeMethod()
public void BM()
{
	System.out.println("Before method starts executing");
}
@AfterSuite()
public void AS()
{
	System.out.println("After Suite starts executing");
}
@AfterTest()
public void AT()
{
	System.out.println("After Test starts executing");
}
@AfterClass()
public void AC()
{
	System.out.println("After class starts executing");
}
@AfterMethod()
public void AM()
{
	System.out.println("After method starts executing");
}
}

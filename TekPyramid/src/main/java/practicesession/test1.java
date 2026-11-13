package practicesession;

import org.testng.annotations.Test;

public class test1 extends BaseClass1 {
@Test(priority=2)
public void m5()
{
	System.out.println("having priority 2");
}
@Test(priority=1)
public void m1()
{
	System.out.println("having priority 1");
}
@Test(groups= {"smokeTest","RegressionTest"})
public void m2()
{
	System.out.println("Executes both smoke and regression testing");
}
@Test(groups="smokeTest")
public void m3()
{
	System.out.println("Executes both smoke testing");
}

@Test(invocationCount=4)
public void m4()
{
	System.out.println("Executes invocation cout of 4");
}
@Test(invocationCount=3,threadPoolSize=3)
public void m6()
{
	System.out.println("Executes invocation count along with thread pool siz");
}
@Test(groups="Resgression",dependsOnGroups="smokeTest")
public void m7()
{
	System.out.println("Executes invocation cout of 4");
}
//@Test(dataProvider="m3",dataProviderClass="BaseClass1.class")
//public void m8()
//{
//	System.out.println("Executes invocation cout of 4");
//}
@Test(groups="systemTest",dependsOnMethods="m5")
public void m9()
{
	System.out.println("Executes invocation cout of 4");
}

}

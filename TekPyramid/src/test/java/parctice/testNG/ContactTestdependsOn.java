package parctice.testNG;

import org.testng.annotations.Test;

public class ContactTestdependsOn {
	@Test
	   public void createContactTest() {
		   System.out.println("execute createContact with -->HDFC");
	   }
	   
	   @Test(dependsOnMethods = "createContactTest")
	   public void modifyContactTest() {
		  // System.out.println("execute query insert contact in DB==> ICICI");
		   System.out.println("execute modifyContactTest-->HDFC->ICICI");
	   }
	   
	   @Test(dependsOnMethods = "modifyContactTest")
	   public void deleteContactTest() {
		   //System.out.println("execute query insert contact in DB==> UPI");
		   System.out.println("execute deleteContactTest ICICI");
	   }
}
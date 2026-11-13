package parctice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
   @Test(dataProvider = "getData")
   public void createContactTest(String firstName,String lastName,long phoneNumber) {
	   System.out.println("FirstName :"+ firstName +", LastName:"+lastName+", PhoneNumber:"+phoneNumber);
   }
   
   @DataProvider
   public Object[][] getData(){
	   Object[][] objArr = new Object[3][3];
	   objArr[0][0] = "deepak";
	   objArr[0][1] = "hr";
	   objArr[0][2] = 98866662219l;
	   
	   objArr[1][0] = "sam";
	   objArr[1][1] = "sh";
	   objArr[1][2] = 98866662276l;
	   
	   objArr[2][0] = "Jhon";
	   objArr[2][1] = "smith";
	   objArr[2][2] = 98866662234l;
	   
	   return objArr;
   }
   
}
package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

//This Program will check expectedProjectName available or not
public class sampleUnitTestCheckProjectInBackend1 {
   @Test
   public void projectCheck() throws SQLException{
	   String expectedProjectName = "FB_01";
	   boolean flag = false;
	   //Step 1:Load/Register the database driver
	   Driver driverRef = new Driver();
	   DriverManager.registerDriver(driverRef);
	   //Step 2:Connect the databse
	   Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
	   System.out.println("==Done==");
	   //Step 3:Create the statement
	   Statement stat = conn.createStatement();
	   //Step 4:Execute select query & get result
	   ResultSet resultset = stat.executeQuery("Select * from project");
	   while(resultset.next()) {
		   String actProjectName = resultset.getString(4);
		   if(expectedProjectName.equals(actProjectName)) {
			   flag = true;
			   System.out.println(expectedProjectName+" is available ==PASS");
		   }
	   }
	   if(flag==false) {
		   System.out.println(expectedProjectName+" is not available==FAIL");
	   }
   }
}
package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {
   Connection conn = null;
   @Test
   public void projectCheck() throws SQLException{
   try {
	   //Step 1:Load/Register the databse driver
	   Driver driverRef = new Driver();
	   DriverManager.registerDriver(driverRef);
	   //Step 2:Connect the database
	   Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
	   System.out.println("===Done===");
       //Step 3:Create the statement
	   Statement stat = conn.createStatement();
	   //Step 4:Execute select query & get result
	   ResultSet resultset = stat.executeQuery("Select * from project123");
	   System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+
	   resultset.getString(5)+"\t"+resultset.getInt(6));
     }catch(Exception e) {
	   System.out.println("Handle Exception");
     }finally {
	   //Step 5:Close the connection
	   conn.close();
	   System.out.println("===Close the connection===");
   }
	   
   }
}
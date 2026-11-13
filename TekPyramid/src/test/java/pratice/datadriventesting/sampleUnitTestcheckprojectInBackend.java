package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class sampleUnitTestcheckprojectInBackend {
@Test
  public void projectCheck() throws SQLException{
	String expectedProjectName = "FB_01";
	//Step 1:load/register the database driver
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	//Step 2:Connect the database
	Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
	System.out.println("===Done===");
	//Step 3:Create sql statement
	Statement stat = conn.createStatement();
	//Step 4:Execute select query & get result
	ResultSet resultset = stat.executeQuery("Select * from project");
	while(resultset.next()) {
		String actProjectName = resultset.getString(4);
		System.out.println(actProjectName);
	}
	
}
}
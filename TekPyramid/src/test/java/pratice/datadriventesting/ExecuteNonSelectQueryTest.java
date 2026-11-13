package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {
    public static void main(String[] args) throws Throwable {
     //step 1:Load/register the database driver
   	 Driver driverRef = new Driver();
   	 DriverManager.registerDriver(driverRef);
   	 //step 2:Connect to database
   	 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
   	 System.out.println("====Done====");
   	 //step 3:Create sql statement
   	 Statement stat = conn.createStatement();
   	 //step 4:Execute select query & get  result
   	 int result = stat.executeUpdate("INSERT INTO project values('NH_PROJ_009','Priya','10/10/2026','Project96','created8',16)");
   	 System.out.println(result+" row inserted");
   	 
   	 //step 5:close the connection
   	 conn.close();
	}
}
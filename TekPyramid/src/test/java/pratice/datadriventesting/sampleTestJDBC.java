package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sampleTestJDBC {
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
    	 ResultSet resultset = stat.executeQuery("select * from project");
    	 while(resultset.next()) {
    		 System.out.println(resultset.getString(1));
    		 System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3));
    		 System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+resultset.getString(5)+"\t"+resultset.getString(6));
    	 }
    	 //step 5:close the connection
    	 conn.close();
    	 
	}
}
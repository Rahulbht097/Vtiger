package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {
	@Test
	public void executeQuery() throws SQLException {
		Connection con=null;
		try {
		//Step 1: Register the database
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		//Step 2: Establish connection with database
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
		//Step 3 : Issue create statement
		Statement stat= con.createStatement();
		//Step 4: Execute the query
		int result= stat.executeUpdate("insert into customer values (3,'RB','RD','11/09/1995');");
		if (result==1) {
			System.out.println("successfull");}
			else 
			{
				System.out.println("unsuccessfull");
			}
		}
		catch (Exception e) {}
		finally {
		con.close();	
		}
		}
	}
package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {
	@Test
	public void executeQ() throws Throwable {
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
		Statement stat = con.createStatement();
		ResultSet result= stat.executeQuery("select*from customer;");
		while(result.next()) {
			System.out.println(result.getString(2));
		}
	}


@Test
	
	public void updateresult() throws SQLException{
		Connection con = null;
		try {
			Driver driverref =  new Driver();
			DriverManager.registerDriver(driverref);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
			Statement stat = con.createStatement();
			int result = stat.executeUpdate("insert into customer values (3,'RB','RD','11/09/1995');");
			if (result == 1) {
				System.out.println("success");
			}
			else{
				System.out.println("unsuccessfull");
		}
		}
			catch(Exception e) {}
			finally {
				con.close();
			}
	}
}
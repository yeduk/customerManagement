package customerManagment.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?useSSL=false","root","root");
			if(conn!=null)
				System.out.println("sus cus");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

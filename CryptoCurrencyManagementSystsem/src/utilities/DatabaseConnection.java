package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

	public static Connection connection;
	public static Statement statement;
	
	static {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptocurrency"+"?useSSl=false", "root", "root");
			statement = connection.createStatement();
		}catch (Exception e) {
			System.out.println(e);
		} 
	}
}

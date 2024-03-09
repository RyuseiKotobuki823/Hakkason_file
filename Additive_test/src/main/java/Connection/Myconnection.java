package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {

	public static Connection getMyCon() throws SQLException{
		final String url 			= "jdbc:mysql://localhost:3306/additive_db";			
		final String dbUserName		= "reiji";
		final String password 		= "pass";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, dbUserName, password);
	}
}

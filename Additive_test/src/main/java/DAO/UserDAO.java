package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	private static Connection myConnection() throws SQLException{
		final String url 			= "jdbc:mysql://localhost:3306/additive_db";
										
		final String dbUserName		= "reiji";
		final String password 		= "pass";
		return DriverManager.getConnection(url, dbUserName, password);
	}
	
	public static int signUpUser(String userName, String userFlontId, String userPassword) {
		System.out.println("メソッド内");
		String sql = "INSERT INTO user_table"
					+"(user_name, user_flont_id, user_password)"
					+ "VALUES"
					+ "( "
						+ "\"" + userName 		+ "\",	"
						+ "\"" + userFlontId 	+ "\",	"
						+ "\"" + userPassword 	+ "\"	"
					+ ")";
		int cnt = 0;
		
		final String url 			= "jdbc:mysql://localhost:3306/additive_db";
		final String dbUserName		= "reiji";
		final String password 		= "pass";
		
		System.out.println("try直前");
		System.out.println(userName);
		System.out.println(userFlontId);
		System.out.println(userPassword);
		
		try(
			Connection con = DriverManager.getConnection(url, dbUserName, password);
			Statement stmt = con.createStatement();)
		{
			cnt = stmt.executeUpdate(sql);
			System.out.println("try中");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		System.out.println("return");
		return cnt;
		
	
		
	}
	
	public static int logInUser(String userFlontId, String password) {
		
		String sql = "SELECT user_flont_id, user_password FROM user_table WHERE user_flont_id = \"" + userFlontId + "\"";
		String userFlontIdInDB = null;
		String passwordInDB = null;
		
		
		try(
			Connection con = myConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);)
		{
			if (res.next()) {
				userFlontIdInDB = res.getString("user_flont_id");
				passwordInDB = res.getString("user_password");
			}else {
				return -1;
			}
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e);
		}
		
		
		if ( (userFlontId.equals(userFlontIdInDB)) 
				&& (password.equals(passwordInDB)) ) {
			return 1;
		}else {
			return -1;
		}
		
	}
	

}

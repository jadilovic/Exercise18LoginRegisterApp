package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOwnDatabase {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/";
	
	public static void main(String[] args) throws SQLException {
		
		String sqlQuery = "CREATE DATABASE profile";
		
		Connection conn = ConnManager.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Database " + databaseName(sqlQuery) + " has been successfuly created");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			System.out.println("Final and complete");
		}
		conn.close();
	}

	private static String databaseName(String sqlQuery) {
		String[] stringList = sqlQuery.split(" ");
		return stringList[stringList.length - 1];
	} 
}

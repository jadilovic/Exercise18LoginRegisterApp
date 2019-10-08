package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProfileTable {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = ConnManDBProfile.getInstance().getConnection();

		String sqlQuery = "CREATE TABLE person ("
				+ "id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, "
				+ "password VARCHAR(20), "
				+ "name VARCHAR(70), "
				+ "lastName VARCHAR(70), "
				+ "work VARCHAR(30), "
				+ "city VARCHAR(30), "
				+ "age DATE, "
				+ "email VARCHAR(70)"
				+ ");";
		
		try{
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Table " + getNameOfTable(sqlQuery) + " was created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
	}

	private static String getNameOfTable(String sqlQuery) {
		String[] stringList = sqlQuery.split(" ");
		return stringList[2];
	}
}

package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManDBProfile {

	private static ConnManDBProfile instance = null;
	
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/profile";
	
	private Connection conn = null;
	
	public ConnManDBProfile(){
		
	}
	
	public static ConnManDBProfile getInstance(){
		if(instance == null)
			instance = new ConnManDBProfile();
		return instance;
	}
	
	private boolean openConnection(){
		try {
			conn = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConnection(){
		if(conn == null){
			if(openConnection()){
				System.out.println("Connection established");
				return conn;
			} else{
				return null;
			}
		}
		return conn;
	}
	
	public void close(){
		System.out.println("Connection is closed");
		try{
			conn.close();
			conn = null;
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

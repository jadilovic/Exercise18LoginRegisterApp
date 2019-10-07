package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {

	private static ConnManager instance = null;
	
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	private Connection conn = null;
	
	public ConnManager(){
		
	}
	
	public static ConnManager getInstance(){
		if(instance == null)
			instance = new ConnManager();
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

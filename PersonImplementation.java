package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonImplementation implements PersonInterface{

	// Connecting to the profile database
	Connection conn = ConnManDBProfile.getInstance().getConnection();
	Scanner input = new Scanner(System.in);
	
	@Override
	public ArrayList<Person> getAllPersons() throws SQLException {
		
		// Creating ArrayList of Person objects
		ArrayList<Person> persons = new ArrayList<>();
		
		// Defining MySQL query
		String sqlQuery = "SELECT * FROM person";
		
		try (	// Creating Java SQL statement
			Statement statement = conn.createStatement();){
			
			// New ResultSet and execution of Query
			ResultSet rs = statement.executeQuery(sqlQuery);
			
			// Adding Person object to ArrayList from MySQL Query results
			while(rs.next()){
				persons.add(new Person(rs.getInt("id"), rs.getString("password"), rs.getString("name"), 
						rs.getString("lastName"), rs.getString("work"), rs.getString("city"), 
						rs.getString("age"), rs.getString("email")));
			}
		}
		return persons;
	}

	@Override
	public Person getPerson(int id, String password) throws SQLException {
		Person person = null;
		String sqlQuery = "SELECT * FROM person WHERE id = ? AND password = ?";
		ResultSet rs = null;
		
		try (PreparedStatement prepStat = conn.prepareStatement(sqlQuery);){
			prepStat.setInt(1, id);
			prepStat.setString(2, password);
			rs = prepStat.executeQuery();
			
			while(rs.next()){
				person = new Person(rs.getInt("id"), rs.getString("password"), rs.getString("name"), 
						rs.getString("lastName"), rs.getString("work"), rs.getString("city"), 
						rs.getString("age"), rs.getString("email"));
			}
		}
		return person;
	}

	@Override
	public void updatePerson(Person person) throws SQLException {
		
		if(person != null){
		
			String sqlQuery = "UPDATE person SET password = ?, name = ?, lastName = ?, "
				+ "work = ?, city = ?, age = ?, email = ? WHERE id = ?";
		
	System.out.println("Enter new password: (old password is " + person.getPassword() + ")");
		String pass = input.nextLine();
	System.out.println("Enter new name: (old name is " + person.getName() + ")");
		String name = input.nextLine();
	System.out.println("Enter new last name: (old last name is " + person.getLastName() + ")");
		String lastName = input.nextLine();
	System.out.println("Enter new work: (old work is " + person.getWork() + ")");
		String work = input.nextLine();
	System.out.println("Enter new city: (old city is " + person.getCity() + ")");
		String city = input.nextLine();
	System.out.println("Enter new age: (old age is " + person.getAge() + ")");
		String age = input.nextLine();
	System.out.println("Enter new email: (old email is " + person.getEmail() + ")");
		String email = input.nextLine();
		
		try(PreparedStatement pstat = conn.prepareStatement(sqlQuery);){
					
					pstat.setString(1, pass);
					pstat.setString(2, name);
					pstat.setString(3, lastName);
					pstat.setString(4, work);
					pstat.setString(5, city);
					pstat.setString(6, age);
					pstat.setString(7, email);
					pstat.setInt(8, person.getId());

					pstat.executeUpdate();
					
					System.out.println("Profile of the person with id " + person.getId() + " was updated\n");
			}
		}
	}

	@Override
	public void deletePerson(Person person) throws SQLException {
		String sqlQuery = "DELETE FROM person WHERE id = ?";
		
		try (PreparedStatement pstat = conn.prepareStatement(sqlQuery);){
			pstat.setInt(1, person.getId());
			pstat.executeUpdate();
			System.out.println("Personal information of user " + person.getName() + " has been deleted");
		}
	}

	@Override
	public void addPerson() throws SQLException {
		String sqlQuery = "INSERT INTO person (id, password, name, lastName, "
				+ "work, city, age, email) VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
		
	System.out.println("Enter password: ");
		String pass = input.nextLine();
	System.out.println("Enter name: ");
		String name = input.nextLine();
	System.out.println("Enter last name: ");
		String lastName = input.nextLine();
	System.out.println("Enter work: ");
		String work = input.nextLine();
	System.out.println("Enter city: ");
		String city = input.nextLine();
	System.out.println("Enter age: ");
		String age = input.nextLine();
	System.out.println("Enter email: ");
		String email = input.nextLine();
		
		try(PreparedStatement pstat = conn.prepareStatement(sqlQuery);){
					
					pstat.setString(1, pass);
					pstat.setString(2, name);
					pstat.setString(3, lastName);
					pstat.setString(4, work);
					pstat.setString(5, city);
					pstat.setString(6, age);
					pstat.setString(7, email);

					pstat.executeUpdate();
					
					System.out.println("Profile of the new user person was created\n");
			}
	}

	@Override
	public void printPerson(Person person) {
		if(person != null){
	System.out.println("id: " + person.getId() + ", password: " + person.getPassword() + ", "
		+ "name: " + person.getName() + ", lastName: " + person.getLastName() + ", work: " + person.getWork() + ", "
		+ "city: " + person.getCity() + ", age: " + person.getAge() + ", email: " + person.getEmail());
		} else{
			System.out.println("No date for the given person object");
		}
	}
	
}

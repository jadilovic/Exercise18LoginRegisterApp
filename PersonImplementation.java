package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonImplementation implements PersonInterface{

	// Connecting to the profile database
	Connection conn = ConnManDBProfile.getInstance().getConnection();
	
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
	public Person getPerson(int id) throws SQLException {
		Person person = null;
		String sqlQuery = "SELECT * FROM person WHERE id = ?";
		ResultSet rs = null;
		
		try (PreparedStatement prepStat = conn.prepareStatement(sqlQuery);){
			prepStat.setInt(1, id);
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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

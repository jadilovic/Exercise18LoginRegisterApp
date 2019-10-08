package DAO_LoginRegisterApp;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Student;

public interface PersonInterface {

	// method to get all persons
	public ArrayList<Person> getAllPersons() throws SQLException;

	// method to get a specific person
	public Person getPerson(int id) throws SQLException;

	// method to update a specific person
	public void updatePerson(Person person) throws SQLException;

	// method to delete a specific person
	public void deletePerson(Person person) throws SQLException;

	// method to add a student
	public void addPerson() throws SQLException;

	// method to print a specific student
	public void printPerson(Person person);
}

package DAO_LoginRegisterApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppLoginRegister {
	
	static PersonImplementation profileApp = new PersonImplementation();
	static Person loggedPerson = null;

	public static void main(String[] args) throws SQLException {
		
		boolean AppIsON = true;
		
		while(AppIsON){
			System.out.println("To log in please choose '1': "
					+ "\nTo register as the new user please choose '2': "
					+ "\nTo see all registered users please choose '3': "
					+ "\nTo exit the App please choose '4': ");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			
			switch (option) {
			case 1: logIn();
			break;
			case 2: register();
			break;
			case 3: printAll();
			break;
			case 4: System.out.println("Exiting the App. Thank you for using LoginRegister App.");
			AppIsON = false;
			break;
			default: System.out.println("You have entered wrong selection. Please try again\n");
				break;
			}
			
			if(loggedPerson != null){
				boolean loggedIn = true;
				System.out.println("You are logged in");
					
				while(loggedIn){
						System.out.println("To update personal information enter '5': "
						+ "\nTo delete all personal information enter '6': "
						+ "\nTo log out enter '7': ");
						option = input.nextInt();
				
					switch (option) {
					
					case 5: update(loggedPerson);
					break;
					
					case 6: delete(loggedPerson);
					System.out.println("You will be automatically logged out as your profile has been deleted\n");
					loggedIn = false;
					loggedPerson = null;
					break;
					
					case 7: loggedIn = false;
					loggedPerson = null;
					System.out.println("Your are logged out.\n");
					break;
					
					default: System.out.println("Entered wrong option. Please try again");
					break;
					}
				}
			}
		}
	}

	private static void delete(Person loggedPerson) throws SQLException {
		profileApp.deletePerson(loggedPerson);
	}

	private static void update(Person loggedPerson) throws SQLException {
		profileApp.updatePerson(loggedPerson);
	}

	private static void printAll() throws SQLException {
		ArrayList<Person> personsList = profileApp.getAllPersons();
		System.out.println("All registered user profiles:");
		for(Person person: personsList)
			profileApp.printPerson(person);
		System.out.println();
	}

	private static void register() throws SQLException {
		profileApp.addPerson();
	}

	private static void logIn() throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your ID number");
		int id = input.nextInt();
		loggedPerson = profileApp.getPerson(id);
		if(loggedPerson == null)
			System.out.println("Entered ID does not exist. Please try agian\n");
		else{
			System.out.println("Current values in the database:");
		profileApp.printPerson(loggedPerson);
		System.out.println();
		}
	}

	private static boolean validId(int id) {
		return false;	
	}

}

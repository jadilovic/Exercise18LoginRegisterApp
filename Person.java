package DAO_LoginRegisterApp;

public class Person {

	private int id;
	private String password;
	private String name;
	private String lastName;
	private String work;
	private String city;
	private String age;
	private String email;
	
	public Person(int id, String password, String name, String lastName, String work, String city, String age, String email){
		this.id = id;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.work = work;
		this.city = city;
		this.age = age;
		this.email = email;
	}
	
	// getter methods
	public int getId(){
		return id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getWork(){
		return work;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getEmail(){
		return email;
	}
}

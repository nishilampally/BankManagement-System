package model;

public class User {
	protected int id;
	protected String name;
	protected int age;
	protected double amount;
	protected String password;
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public User() {
	}
	
	

	public User(int id, String name, int age, double salary, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.amount = salary;
		this.password = password;
	}



	public User(String name, int age, double salary, String password) {
		super();
		this.name = name;
		this.age = age;
		this.amount = salary;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getSalary() {
		return amount;
	}



	public void setSalary(double salary) {
		this.amount = salary;
	}

}
package com.example.organization;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {
	
	@Id
	private int id;
	public String name;
	public String surname;
	public String address;
	public String function;
	public String email;
	public String password;
	public int age;
	public double donation;

	

	public Member() {
		super();}
	
	public Member(int id, String name, String surname, String address, String function, String email,String password, int age, double donation) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.function = function;
		this.email = email;
		this.password = password;
		this.age = age;
		this.donation = donation;
		
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
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAdress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.email = function;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getDonation() {
		return donation;
	}
	public void setDonation(double donation) {
		this.donation = donation;
	}
	
	


	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", function=" + function + ", email=" + email + ", password=" + password + ", + age=" + age + ", + donation=" + donation + "]\n";
	}
	
}
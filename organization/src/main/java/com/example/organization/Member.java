package com.example.organization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public String name;
	public String surname;
	public String address;
	public String email;
	public String password;
	public int age;
	public double amount;
	
	//private List<Expense> expenses;
	public Member() {
			super();}
	
	public Member(String name, String surname, String address, String email, String password, int age, double amount) {
		super();
		
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.age = age;
		this.amount = amount;
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", email=" + email + ", password=" + password + ", age=" + age + ", amount =" + amount
				+ "]\n";
	}
	
	
	
}
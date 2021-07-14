package com.example.organization;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String product;
	private int quantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private double value;
	
		
	public Expense() {
		super();
	}
	public Expense(String name, String product, int quantity, Date date, double value) {
		super();
	
		this.name = name;
		this.name = product;
		this.quantity = quantity;
		this.date = date;
		this.value = value;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", product=" + product + ", quantity= " + quantity + ", date=" + date + ", value=" + value + "]";
	}
	

}

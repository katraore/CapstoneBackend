package com.medicare.backend.entity;


import javax.persistence.OneToMany;


public class Product {
	
	private int pid;
	private String pname;
	private double price;
	private String description;
	@OneToMany
	private Category cat;
	public Product() {
	}
	public Product(int pid, String pname, double price, String description, Category cat) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.cat = cat;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", description=" + description
				+ ", cat=" + cat + "]";
	}

}

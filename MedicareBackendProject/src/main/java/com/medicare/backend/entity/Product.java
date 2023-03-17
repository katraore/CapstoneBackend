package com.medicare.backend.entity;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private double price;
	private long quantity;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional =false)
	@JoinColumn(name="cid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	@ManyToOne
	private Cart cart;
	
	
	public Product() {
	}


	public Product(int pid, String pname, double price, long quantity, String description, Category category,
			Cart cart) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
		this.cart = cart;
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




	public long getQuantity() {
		return quantity;
	}




	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public Cart getCart() {
		return cart;
	}




	public void setCart(Cart cart) {
		this.cart = cart;
	}




	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity
				+ ", description=" + description + ", category=" + category + ", cart=" + cart + "]";
	}



}

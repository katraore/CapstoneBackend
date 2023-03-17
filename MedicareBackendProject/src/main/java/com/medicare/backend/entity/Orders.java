package com.medicare.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	private Date orderDate = new Date(System.currentTimeMillis());
	private Date shippedDate;
	
	public Orders() {
	}


	public Orders(int oid, Date orderDate, Date shippedDate) {
		super();
		this.oid = oid;
		this.orderDate = orderDate;
		this.shippedDate = shippedDate;
	}


	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}


	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}


	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", orderDate=" + orderDate + ", shippedDate=" + shippedDate + "]";
	}


}

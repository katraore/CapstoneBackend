package com.medicare.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int oid;
	@Column
	private Date order_date;
	@Column
	private Date shipped_date;
	
	public Order() {
		super();
	}
	
	public Order(int oid, Date order_date, Date shipped_date) {
		super();
		this.oid = oid;
		this.order_date = order_date;
		this.shipped_date = shipped_date;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int cid) {
		this.oid = cid;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getShipped_date() {
		return shipped_date;
	}

	public void setShipped_date(Date shipped_date) {
		this.shipped_date = shipped_date;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", order_date=" + order_date + ", shipped_date=" + shipped_date + "]";
	}
	
	

}

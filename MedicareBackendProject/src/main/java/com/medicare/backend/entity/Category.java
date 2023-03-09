package com.medicare.backend.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class Category {
	

	private int cid;
	private String cname;
	
	private List<Product> products;

}

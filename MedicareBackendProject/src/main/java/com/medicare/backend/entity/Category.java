package com.medicare.backend.entity;

import java.util.List;

import javax.persistence.ManyToOne;

public class Category {
	
	private int cid;
	private String cname;
	@ManyToOne
	private List<Product> products;

}
